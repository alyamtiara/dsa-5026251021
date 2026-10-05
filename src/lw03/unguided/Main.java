package lw03.unguided;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        List<String> check = new ArrayList<>();
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        int gagal = 0;
        while(scan.hasNextLine()){
            String input = scan.nextLine();
            String[] parts = input.split(" ");
            String aksi = parts[0];
            String couseCode = parts[1];

            if(aksi.equals("REGISTER")){
                int count = Integer.parseInt(parts[2]);
                if(enrollment.containsKey(couseCode)){
                    enrollment.put(couseCode, enrollment.get(couseCode) + count);
                }else{
                    enrollment.put(couseCode, count);
                }
            }else if(aksi.equals("WITHDRAW")){
                int count = Integer.parseInt(parts[2]);
                if(count <= 0){
                    gagal++;
                }else{
                    if(enrollment.containsKey(couseCode)&& enrollment.get(couseCode) >= count){
                        enrollment.put(couseCode, enrollment.get(couseCode) - count);
                    }else{
                        gagal++;
                    }
                }
            } else if (aksi.equals("CHECK")){
                if(enrollment.containsKey(couseCode)){
                    check.add(couseCode + " : " + enrollment.get(couseCode) + " students");
                }else{
                    check.add(couseCode + " : Not Found");
                    gagal++;
                }
            }
        }
        System.out.println("==== Enrollment Checks ====");
        for(String result : check){
            System.out.println(result);
        }
        System.out.println();

        System.out.println("==== Final Enrollment ====");
        for(String key : enrollment.keySet()){
            System.out.println(key + " : " + enrollment.get(key) + " students");
        }
        System.out.println();
        
        System.out.println("Rejected operations: " + gagal);
    }
}
