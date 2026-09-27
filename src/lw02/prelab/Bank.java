package lw02.prelab;
import java.util.*;

public class Bank {
    
    public static void main(String[] args){

        LinkedList<String[]> daftarTransaksi = new LinkedList<>();
        LinkedList<String[]> pelanggan = new LinkedList<>();

        Scanner scan =  new Scanner(Bank.class.getResourceAsStream("transactions.txt"));

        HashSet<String> cekNama = new HashSet<>();
        while (scan.hasNext()){

            String[] transaksi = new String[3];
            transaksi[0] = scan.next();  
            transaksi[1] = scan.next();
            transaksi[2] = scan.next();

            daftarTransaksi.add(transaksi);

       if (cekNama.add(transaksi[0])){
            String[] namaPelanggan = new String[2];
            namaPelanggan[0] = transaksi[0];
            namaPelanggan[1] = "0";
            pelanggan.add(namaPelanggan);
        }
    } 
    Queue<String[]> prosesTransaksi = new LinkedList<>();
    for (String[] t : daftarTransaksi){
        prosesTransaksi.add(t);
    }

    Stack<String[]> transaksiGagal = new Stack<>();
    while (!prosesTransaksi.isEmpty()){
        String[] t = prosesTransaksi.poll();
        String nama = t[0];
        String jenisTransaksi = t[1];
        int jumlah = Integer.parseInt(t[2]);

        for (String[] p : pelanggan){
            if (p[0].equals(nama)){
                int saldoSaatIni = Integer.parseInt(p[1]);

                if (jenisTransaksi.equals("DEPOSIT")){
                    saldoSaatIni += jumlah;
                    p[1] = String.valueOf(saldoSaatIni);
                } else if (jenisTransaksi.equals("WITHDRAW")){
                    if (jumlah > saldoSaatIni){
                       transaksiGagal.push(t);
                    } else {
                        saldoSaatIni -= jumlah;
                        p[1] = String.valueOf(saldoSaatIni);
                    }
                }
            } 
        }
    }

        System.out.println("=== Final Balances ===");
        for (String[] p : pelanggan) {
            System.out.println(p[0] + ": " + p[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!transaksiGagal.isEmpty()) {
            String[] gagal = transaksiGagal.pop();
            System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2]);
        }
    }
}