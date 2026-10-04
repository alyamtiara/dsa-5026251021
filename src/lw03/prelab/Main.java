package lw03.prelab;
import java.util.*;
public class Main {
    public static void main(String[] args){
        
        //problem 1
        Scanner scan = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();

        while(scan.hasNext()){
            String input = scan.nextLine();
            String action = input.substring(0, input.indexOf(" "));

            if(action.equals("ADD")){
                String judulLagu = input.substring(input.indexOf(" ") + 1);
                playlist.add(judulLagu);
            }else if(action.equals("REMOVE")){
                String judulLagu = input.substring(input.indexOf(" ") + 1);
                playlist.remove(judulLagu);
            }else{
                String spasiAwal = input.substring(input.indexOf(" ") + 1);
                int index = Integer.parseInt(spasiAwal.substring(0, spasiAwal.indexOf(" ")));
                String judulLagu = spasiAwal.substring(spasiAwal.indexOf(" ") + 1);
                playlist.add(index, judulLagu);
            }

        }
        System.out.println("=== PROBLEM 1 ===");
        System.out.println("Total Songs: " + playlist.size());
        int num = 1;
        for(String lagu : playlist){
            System.out.println(num + " : " + lagu);
            num++;
        }

        //problem 2
        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;

        while(sc.hasNext()){
            String nama = sc.nextLine();
            if(participants.contains(nama)){
                duplicate++;
            }
            participants.add(nama);
        }

        System.out.println("=== PROBLEM 2 ===");
        System.out.println("Unique Participants: " + participants.size());

        int nomor = 1;
        for(String nama : participants){
            System.out.println(nomor + " : " + nama);
            nomor++;
        }
        System.out.println("Duplicate Registrations: " + duplicate);

        //problem 3
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int gagal = 0;
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            String[] part = input.split(" ");
            String aksi = part[0];
            String namaBarang = part[1];
            int jumlah = Integer.parseInt(part[2]);

            if(aksi.equals("ADD")){
                if(inventory.containsKey(namaBarang)){
                    inventory.put(namaBarang, inventory.get(namaBarang) + jumlah);
                }else{
                    inventory.put(namaBarang, jumlah);
                }
            }else{
                if(inventory.containsKey(namaBarang) && inventory.get(namaBarang) >= jumlah){
                    inventory.put(namaBarang, inventory.get(namaBarang) - jumlah);
                }else{
                    gagal++;
                }
            }
        }
        System.out.println("===PROBLEM 3==="); 

        for(String key : inventory.keySet()){
            System.out.println(key + " : " + inventory.get(key));
        }

        System.out.println("Failed sales: " + gagal);
    }

}
