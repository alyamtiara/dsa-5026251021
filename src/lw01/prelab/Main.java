package lw01.prelab;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        List<PrintJob> jobs = new ArrayList<>();

        Scanner scan = new Scanner(new File("src/lw01/prelab/jobs.txt"));

        while (scan.hasNext()) {
            String type = scan.next();
            String id = scan.next();
            int pages = scan.nextInt();

            if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }

        scan.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}