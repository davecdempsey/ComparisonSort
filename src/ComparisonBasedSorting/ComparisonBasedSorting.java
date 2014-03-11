/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonBasedSorting;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author davidcdempsey
 */

public class ComparisonBasedSorting {

    private static int inputSize;
    private static int sortingType;
    private static int inputOrder;
    private static int[] comparisionArray;
    private static ComparisonSort[] sort;
    private static boolean runAgain;

     public static void main(String[] args) {
         runAgain = true;
         while(runAgain){
             Sort();
         }
         
     }
    
    public static void Sort() {

        sort = new ComparisonSort[4];
        for(int i = 0; i < sort.length; i += 1){
            sort[i] = null;
        }
        
        // Get Sorting Type
        GetSortingType();
        System.out.println("\n");
        // Get Input Size
        GetInputSize();
        System.out.println("\n");
        // Get Input Order
        GetInputOrder();
        System.out.println("\n");
        // Fill Array
        FillArray(inputOrder);
        
        switch(sortingType){
            case 1:
                sort[0] = new MergeSort(comparisionArray);
                break;
            case 2:
                sort[0] = new HeapSort(comparisionArray);
                break;
            case 3:
                sort[0] = new QuickSort(comparisionArray, false);
                break;
            case 4:
                sort[0] = new QuickSort(comparisionArray, true);
                break;
            case 5:
                sort[0] = new MergeSort(comparisionArray);
                sort[1] = new HeapSort(comparisionArray);
                sort[2] = new QuickSort(comparisionArray, false);
                sort[3] = new QuickSort(comparisionArray, true);
                
                break;
                
        }
        
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Do you want to see sorted array?");
       System.out.println("1. Yes");
       System.out.println("2. No");
       ShowResults(sort, keyboard.nextInt());
        
       System.out.println("\n");
       System.out.println("Do you want to see sort another array?");
       System.out.println("1. Yes");
       System.out.println("2. No");
       if(keyboard.nextInt() == 2){
           runAgain = false;
       }
       else{
           System.out.println("\n");
           System.out.println("\n");
       }
    }
    
    private static void ShowResults(ComparisonSort[] sort, int showSorted){
        
        for(int i = 0; i < sort.length; i += 1){
            if(sort[i] != null){
                System.out.println("\n" + sort[i].GetSortingType());
        
                if(showSorted == 1){
                    for(int j = 0; j < sort[i].GetSorted().length; j += 1){
                        System.out.println(sort[i].GetSorted()[j]);
                
                    }
                    
                }
                System.out.println("Time of Execution: " + sort[i].GetTimeOfExecution() + "\n");
            }
        }
    }
    
    private static void FillArray(int order){
        comparisionArray = new int[inputSize];
        switch(order){
            // randomOrder
            case 1:
                Random generator = new Random();
                for(int i = 0; i < inputSize; i += 1){
                    comparisionArray[i] = generator.nextInt();
                }
                break;
            
            // inorder
            case 2:
                for(int i = 0; i < inputSize; i += 1){
                    comparisionArray[i] = i;
                }
                break;  
           
            // reverse order
            case 3:
                 for(int i = 0; i < inputSize; i += 1){
                    comparisionArray[i] = inputSize - i;
                }
                break;  
        }
    }
    
    // Functions gets how large the array size will be
    private static void GetInputSize(){
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Please Enter the Desired Input Size");
       inputSize = keyboard.nextInt();
    }
 
    // Function gets the type of sorting the user desires
    private static void GetSortingType(){
        
        boolean askForType = true;
        
        Scanner keyboard = new Scanner(System.in);
        
        while(askForType){
            System.out.println("How do you want to sort these numbers?");
            System.out.println("1. Merge-Sort");
            System.out.println("2. Heap-Sort");
            System.out.println("3. Inplace Quick-Sort");
            System.out.println("4. Modified Quick-Sort");
            System.out.println("5. All");
            System.out.println("Please Enter Number Cooresponding to Desired Sorting Algorithm");
            sortingType = keyboard.nextInt();
            if(sortingType > 5 || sortingType < 1){
                System.out.println("Please enter a number within range \n");
            }
            else{
                askForType = false;
            }
        }
        
    }
    
    private static void GetInputOrder(){
        boolean askForType = true;
        
        Scanner keyboard = new Scanner(System.in);
        
        while(askForType){
            System.out.println("How do you want input ordered?");
            System.out.println("1. Random");
            System.out.println("2. Already Sorted");
            System.out.println("3. Reverse Sorted");
            System.out.println("Please Enter Number Cooresponding to Desired Sorting Algorithm");
            inputOrder = keyboard.nextInt();
            if(inputOrder > 3 || inputOrder < 1){
                System.out.println("Please enter a number within range \n");
            }
            else{
                askForType = false;
            }
        }
    }
}
