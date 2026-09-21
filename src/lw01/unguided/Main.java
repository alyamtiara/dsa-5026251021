package lw01.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Rental[] rentals;
        Scanner scan = new Scanner (Main.class.getResourceAsStream("rentals.txt"));
        int T = scan.nextInt();
        rentals = new Rental[3];
        
        for (int i = 0; i < T; i++){
            String type = scan.next();
            String id = scan.next();
            int days = scan.nextInt();
            int units = scan.nextInt();

            if (type.equals("LAPTOP")){
                rentals[i]= new LaptopRental(id, days,units);
            } else {
                rentals[i] = new ProjectorRental(id, days, units); 
            }
            rentals[i] = rental[i];
        }
        
       for (rental : rentals){
            System.out.println(rental.summary());
        }
    }
    
}
