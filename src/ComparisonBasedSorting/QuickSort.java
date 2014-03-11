/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonBasedSorting;

import java.util.*;

/**
 *
 * @author davidcdempsey
 */
public class QuickSort extends ComparisonSort{
    private int[] comparisionArray;

    private boolean modified;
    
    private long totalTime;
     
    public QuickSort(int[] comparisionArray, boolean modified){
        this.comparisionArray = comparisionArray;
        this.modified = modified;

        long startTime = System.currentTimeMillis();
        if(modified){
            if(comparisionArray.length < 11){
                InsertionSort insertionSort  = new InsertionSort(comparisionArray, 0, comparisionArray.length - 1);
                comparisionArray = insertionSort.GetSortedArray();
            }
            else{
                comparisionArray = ModifiedQuickSort(comparisionArray, 0, comparisionArray.length - 1);
            }
            
        }
        else{
            comparisionArray = InplaceQuickSort(comparisionArray, 0, comparisionArray.length - 1);
        }
        
        long endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;

    }
    
    private int[] InplaceQuickSort(int[] sequence, int leftIndex, int rightIndex){
        Random generator = new Random();
        
        int currentSequenceSize = rightIndex - leftIndex;

        if(currentSequenceSize == 1){
            if(sequence[leftIndex] > sequence[rightIndex]){
                sequence = Swap(rightIndex, leftIndex, sequence);
            }
            return sequence;
        }
        
        if(!(currentSequenceSize > 1)){
            return sequence;
        }
        
        int pivotIndex;
        int pivot;
        int l;
        int r;
        
        
        pivotIndex = generator.nextInt(currentSequenceSize - 1) + leftIndex;
        pivot = sequence[pivotIndex];
            
             
        sequence[pivotIndex] = sequence[leftIndex];
        sequence[leftIndex] = pivot;
            
        l = leftIndex + 1;
        r = rightIndex;
       
        
        boolean searchLeft = true;
        boolean searchRight = true;
        boolean stopSort = false;
      
        
        while(l != r && !stopSort){
            
            
            if (searchLeft){
                if(sequence[l] > pivot){
                    searchLeft = false;
                }
                else if(sequence[l]  == pivot){
                    searchLeft = false;
                }
                else{
                   
                    if(l + 1 < r){
                        l += 1;
                    }
                    else{
                        stopSort = true;
                    }
                    
                }
                
            }
           
            if (searchRight){
                if(sequence[r] < pivot){
                    searchRight = false;
                }

              
                else{
                   
                        
                    if(r - 1 > l){
                        r -= 1;
                    }
                    else{
                        stopSort = true;
                    }
                }
                
            }

            if(!searchLeft && !searchRight){
                
                sequence = Swap(l, r, sequence);
                
                searchLeft = true;
                searchRight = true;
                
                
              
                if(l + 1 < r){
                    l += 1;
                }
                else{
                    stopSort = true;
                }
                
                
                if(r - 1 > l){
                    r -= 1;
                }
            }
        }
        
       
        int newPivotIndex;
        
        if(sequence[leftIndex] < sequence[l]){
            
            newPivotIndex = l - 1;
           
        }
        
        else if(sequence[leftIndex] > sequence[r]){
            
            newPivotIndex = r;
            
        }
        else{
            newPivotIndex = l;
        
        }
        
        
        sequence[leftIndex] = sequence[newPivotIndex];
        sequence[newPivotIndex] = pivot;
        
        sequence = InplaceQuickSort(sequence, leftIndex, newPivotIndex - 1);
        sequence = InplaceQuickSort(sequence, newPivotIndex + 1, rightIndex);
        
        return sequence;
    }
    
    private int[] Swap(int index1, int index2, int[] sequence){
        
        int temp = sequence[index1];
        sequence[index1] = sequence[index2];
        sequence[index2] = temp;

        return sequence;
    }
    
    private int[] ModifiedQuickSort(int[] sequence, int leftIndex, int rightIndex){

       int currentSequenceSize = rightIndex - leftIndex;

       if(currentSequenceSize == 1){
            if(sequence[leftIndex] > sequence[rightIndex]){
                sequence = Swap(rightIndex, leftIndex, sequence);
            }
            return sequence;
        }
        
        if(!(currentSequenceSize > 1)){
            return sequence;
        }

        sequence = MidanOfThree(leftIndex, rightIndex, sequence);
        
        int pivot = sequence[rightIndex - 1];
        int l = leftIndex;
        int r = rightIndex - 2;
      
        
        boolean searchLeft = true;
        boolean searchRight = true;
        boolean stopSort = false;
      
        
        while(l != r && !stopSort){
            
            
            if (searchLeft){
                if(sequence[l] > pivot){
                    searchLeft = false;
                }
                else if(sequence[l]  == pivot){
                    searchLeft = false;
                }
                else{
                   
                    if(l + 1 < r){
                        l += 1;
                    }
                    else{
                        stopSort = true;
                    }
                    
                }
                
            }
           
            if (searchRight){
                if(sequence[r] < pivot){
                    searchRight = false;
                }

              
                else{
                   
                        
                    if(r - 1 > l){
                        r -= 1;
                    }
                    else{
                        stopSort = true;
                    }
                }
                
            }

            if(!searchLeft && !searchRight){
                
                sequence = Swap(l, r, sequence);
                
                searchLeft = true;
                searchRight = true;
                
                
              
                if(l + 1 < r){
                    l += 1;
                }
                else{
                    stopSort = true;
                }
                
                
                if(r - 1 > l){
                    r -= 1;
                }
            }
        }
        
       
        int newPivotIndex;
        
        if(sequence[rightIndex - 1] < sequence[l]){
            
            newPivotIndex = l;
           
        }
        
        else if(sequence[rightIndex - 1] > sequence[r]){
            
            newPivotIndex = r + 1;
            
        }
        else{
            newPivotIndex = r;
        
        }
        
        
        sequence[rightIndex - 1] = sequence[newPivotIndex];
        sequence[newPivotIndex] = pivot;
        
        sequence = ModifiedQuickSort(sequence, leftIndex, newPivotIndex - 1);
        sequence = ModifiedQuickSort(sequence, newPivotIndex + 1, rightIndex);
          
        return sequence;
    }
    
    private int[] MidanOfThree(int leftIndex, int rightIndex, int[] sequence){
        
        int center = (leftIndex + rightIndex) / 2;

        if (sequence[center] < sequence[leftIndex] )
            sequence = Swap(leftIndex, center, sequence);
            
        if ( sequence[rightIndex] < sequence[leftIndex] )
            sequence = Swap(leftIndex, rightIndex, sequence);
            
        if ( sequence[rightIndex] < sequence[center] )
            sequence = Swap(center, rightIndex, sequence);
            
        sequence = Swap(center, (rightIndex - 1), sequence);
        
        return sequence;
    }
    
    public String GetSortingType(){
      if(modified){
          return "Modified Quick Sort";
      }
      else{
          return "Inplace Quick Sort";
      }
    }
    
    public long GetTimeOfExecution(){
      return totalTime;
    }
    
    public int[] GetSorted(){
        return comparisionArray;
    }
    
}
