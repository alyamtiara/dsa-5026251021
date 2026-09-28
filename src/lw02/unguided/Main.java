package lw02.unguided;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedRequest = new Stack<>();

        Scanner scan = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (scan.hasNext()) {
            String[] requestData = new String[3];
            requestData[0] = scan.next();
            requestData[1] = scan.next();
            request.add(requestData);
        }
        scan.close();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Kimia", "2"});

        queue.addAll(request);

        while (!queue.isEmpty()){
            String[] requestBook = queue.poll();
            String name = requestBook[0];
            String bookName = requestBook[1];

            String[] member = null;

            for(String[] m : members){
                if(m[0].equals(name)){
                    member = m;
                    break;
                }
            }

            if(member == null){
                member = new String[]{name, "0"};
                members.add(member);
            }

            String[] book = null;
            for(String[] b : books){
                if(b[0].equals(bookName)){
                    book = b;
                    break;
                }
            }

            if(book != null){
                int stock = Integer.parseInt(book[1]);
                int borrowed = Integer.parseInt(member[1]);

                if (stock > 0 && borrowed < 2){
                    stock--;
                    borrowed++;
                    book[1] = String.valueOf(stock);
                    member[1] = String.valueOf(borrowed);
                } else {
                    failedRequest.push(requestBook);
                }
            } else {
                failedRequest.push(requestBook);
            }
        }
        System.out.println("=== Successfully Processed Requests ===");
        for(String[] req :  queue){
            System.out.println(req[0] + " " + req[1]);
        }

        System.out.println("=== Remaining Book Stock ===");  
        for(String[] b : books){
            System.out.println(b[0] + " " + b[1]);
        }

        System.out.println("=== Failed Requests ===");
        while(!failedRequest.isEmpty()){
            String[] failed = failedRequest.pop();
            System.out.println(failed[0] + " " + failed[1]);
        }       
    }
}

