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
public abstract class ComparisonSort {
    
    int arraySize;
    
    int[] comparisionArray;
    
    long totalTime;
    
    public ComparisonSort(){
        
    }
    
     public String GetSortingType(){
         return "";
     }
     
     public int[] GetSorted(){
        return comparisionArray;
   }
     
     public long GetTimeOfExecution(){
      return totalTime;
  }
    
}
