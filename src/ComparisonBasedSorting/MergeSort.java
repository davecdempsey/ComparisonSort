/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComparisonBasedSorting;

/**
 *
 * @author davidcdempsey
 */
public class MergeSort extends ComparisonSort{    
    private int[] comparisionArray;
    
    private long totalTime;
    
    private int[] sorted;
    
    public MergeSort(int[] comparisionArray){
        this.comparisionArray = comparisionArray;
      
        
        long startTime = System.currentTimeMillis();
        sorted = Sort(comparisionArray, comparisionArray.length);
        long endTime = System.currentTimeMillis();
   
        totalTime = endTime - startTime;
    }
   
    private int[] Sort(int[] sequence, int size){
        int[] arrayReturned;
        
        if(sequence.length > 1){
            
            // partition
            int leftSize = size / 2;
            int rightSize = size - leftSize;
            int[] leftSide = new int[leftSize];
            int[] rightSide = new int[rightSize];
            
            int sequenceIndex = 0;
            
            for(int i = 0; i < leftSize; i += 1){
                leftSide[i] = sequence[sequenceIndex++];
            }
            for(int j = 0; j < rightSize; j += 1){
                rightSide[j] = sequence[sequenceIndex++];
            }
            
            // sort each side
            leftSide = Sort(leftSide, leftSide.length);
            rightSide = Sort(rightSide, rightSide.length);
            
            // merge the sides
            arrayReturned = Merge(leftSide, rightSide);
        }
        else{
            arrayReturned = sequence;
        }
        
        return arrayReturned;
    }
    
    private int[] Merge(int[] leftSide, int[] rightSide){
        int newArraySize = leftSide.length + rightSide.length;
        int[] arrayReturned = new int[newArraySize];
        
        int arrayReturnedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        
        while(leftIndex < leftSide.length && rightIndex < rightSide.length){
            if(leftSide[leftIndex] < rightSide[rightIndex]){
                arrayReturned[arrayReturnedIndex++] = leftSide[leftIndex++];
            }
            else{
                arrayReturned[arrayReturnedIndex++] = rightSide[rightIndex++];
            }
        }
        
        while(leftIndex < leftSide.length){
             arrayReturned[arrayReturnedIndex++] = leftSide[leftIndex++];
        }
        
        while(rightIndex < rightSide.length){
            arrayReturned[arrayReturnedIndex++] = rightSide[rightIndex++];
        }
        
        return arrayReturned;
    }
    
    public long GetTimeOfExecution(){
      return totalTime;
  }
  
  public String GetSortingType(){
      return "Merge Sort";
  }
  
  public int[] GetSorted(){
        return sorted;
   }
}
