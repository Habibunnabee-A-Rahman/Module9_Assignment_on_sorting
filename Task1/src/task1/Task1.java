/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task1;
import java.util.*;
/**
 *
 * @author himal
 */
public class Task1 {

    /**
     * @param args the command line arguments
     */
    
    static void bubbleSort(int[] arr){
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    swap = true;
                    int temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]= temp;
                }
            }
        }
        
        
    }
    
    static void selectionSort(int [] arr){
        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            int min_index = i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[min_index] = temp;
            
        }
        
    }
    
    static void insertionSort(int [] arr){
        
        for(int i=1;i<arr.length;i++){
            
            int current = arr[i];
            int insert_index = i;
            
            for(int j=0;j<i;j++){
                if(current<arr[j]){
                    insert_index = j;
                    break;
                }
            }
            for(int j=i-1;j>=insert_index;j--){
                arr[j+1] = arr[j];
            }
            arr[insert_index] = current;
            
        }
        
    }
    
    
    
    
    static void mergeSection(int[]arr,int left,int mid,int right){
        
        int sec1 = mid-left+1;
        int sec2 = right - mid;
        
        int [] arr1 = new int[sec1];
        int [] arr2 = new int [sec2];
        
        for(int i=0;i<sec1;i++){
            arr1[i] = arr[left+i];
        }
        for(int i=0;i<sec2;i++){
            arr2[i] = arr[mid+1+i];
        }
        
        
        int arr_index = left;
        int l =0;
        int r = 0;
        while(l<sec1 && r<sec2){
            if(arr1[l]<arr2[r]){
                arr[arr_index] = arr1[l];
                l++;
                
            }else{
                arr[arr_index] = arr2[r];
                r++;
            }
            arr_index++;
        }
        while(l<sec1){
            arr[arr_index++] = arr1[l++];
            
        }
        while(r<sec2){
            arr[arr_index++] = arr2[r++];
            
        }
        
        
        
    }
    static void mergeSort(int [] arr,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            mergeSection(arr,left,mid,right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 1000;
        int [] unsorted = new int[n];
        int [] bubble = new int[n];
        int [] selection = new int[n];
        int [] insertion = new int[n];
        int [] merge = new int[n];
        for(int i=0;i<n;i++){
            unsorted[i] = 0 + (int)(Math.random()*10000);
            bubble[i] = unsorted[i];
            selection[i]= unsorted[i];
            insertion[i] = unsorted[i];
            merge[i] = unsorted[i];
        }
        long startTime = System.nanoTime();
        bubbleSort(bubble);
        long endTime = System.nanoTime();
        double timeReq =(double)(endTime-startTime)/1000000000;
        System.out.println("Bubble Sort Time: "+String.format("%.3f", timeReq)+"sec");
        
        startTime = System.nanoTime();
        selectionSort(selection);
        endTime = System.nanoTime();
        timeReq =(double)(endTime-startTime)/1000000000;
        System.out.println("Selection Sort Time: "+String.format("%.3f", timeReq)+"sec");
        
        startTime = System.nanoTime();
        insertionSort(insertion);
        endTime = System.nanoTime();
        timeReq =(double)(endTime-startTime)/1000000000;
        System.out.println("Insertion Sort Time: "+String.format("%.3f", timeReq)+"sec");
        
        startTime = System.nanoTime();
        mergeSort(merge,0,n-1);
        endTime = System.nanoTime();
        timeReq =(double)(endTime-startTime)/1000000000;
        System.out.println("Merge Sort Time: "+String.format("%.3f", timeReq)+"sec");
        
        
        
        
        
        Arrays.sort(unsorted);
        System.out.print("All sorts correct? ");
        for(int i=0;i<n;i++){
            if(unsorted[i]!=bubble[i] || unsorted[i]!=selection[i] || unsorted[i]!=insertion[i] || unsorted[i]!=merge[i]){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
        
//        for(int i=0;i<n;i++){
//            System.out.println(unsorted[i]);
//        }
//        System.out.println();
//        for(int i=0;i<n;i++){
//            System.out.println(merge[i]);
//        }
        //bublesort
        
        
        
        
        
    }
    
}
