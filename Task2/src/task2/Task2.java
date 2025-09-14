/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task2;

import java.util.*;

/**
 *
 * @author himal
 */
public class Task2 {

    /**
     * @param args the command line arguments
     */
    
    static List<String> sort_strings(List<String> list){
        int n = list.size();
        int [][] size = new int[n][2];
        for(int i=0;i<n;i++){
            size[i][0] = i;
            size [i][1] = list.get(i).length();
        }
        Arrays.sort(size,(a,b)->Integer.compare(a[1], b[1]));
        List<String> sortedList = new ArrayList<>();
        for(int i=0;i<n;i++){
            sortedList.add(list.get(size[i][0]));
        }
        
        for(int i=0;i<n;i++){
            int len = sortedList.get(i).length();
            int j=i+1;
            while(j<n&&sortedList.get(j).length()==len){
                j++;
            }
            
            Collections.sort(sortedList.subList(i, j));
        }
        
        
        return sortedList;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       List<String> list = new ArrayList<>();
       System.out.println("Enter the number of strings:");
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt();
       System.out.println("Enter the Strings");
       for(int i =0;i<n;i++){
           list.add(scan.next());
       }
       System.out.println(sort_strings(list));
       
    }
    
}
