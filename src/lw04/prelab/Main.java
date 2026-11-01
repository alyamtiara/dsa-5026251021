package lw04.prelab;

import java.util.Scanner;

public class Main {
    
    public static void insertionSort(int[] array, int pass){
        for(int i = 1; i<= pass; i++){
            int simpan = array[i];
            int j = i-1;

            while(j >= 0 && array[j] < simpan){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = simpan;
        }
    }

    static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; 
            }
        }
        return -1; 
    }
    public static void main(String[] args){
        Scanner scan =  new Scanner(Main.class.getResourceAsStream("branch.txt"));

        int N = scan.nextInt();
        int[] branch = new int[N];
        for(int i=0; i<N; i++){
            branch[i] = scan.nextInt();
        }
        int M = scan.nextInt();
        int[] target = new int[M];
        for(int i=0; i<M; i++){
            target[i] = scan.nextInt();
        }

        insertionSort(branch, 3);
        for(int i=0; i<branch.length; i++){
            System.out.print(branch[i] + " ");
        }
        System.out.println();
        for(int t : target){
            int hasil = linearSearch(branch, t);

            if(hasil == -1){
                System.out.println(t + ": NOT FOUND");
            } else {
                System.out.println(t + ": FOUND at index " + hasil);
            }
    }
}
} 
