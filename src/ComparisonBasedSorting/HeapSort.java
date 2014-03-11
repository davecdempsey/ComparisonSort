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
public class HeapSort extends ComparisonSort{
    private int[] comparisionArray;
    private long totalTime;

    
    public HeapSort(int[] comparisionArray){
        this.comparisionArray = comparisionArray;
        
        long startTime = System.currentTimeMillis();
        
        Sort(comparisionArray.length - 1);
        
        long endTime = System.currentTimeMillis();
        
        totalTime = endTime - startTime;
        
      
    }
    
    private void Sort(int lastLeaf){
         
        BuildMaxHeap(lastLeaf);
    
        while (lastLeaf > 0) {
          Swap(0, lastLeaf);       
          lastLeaf -= 1;                
          MaxHeapify(0, lastLeaf); 
        }

    }
    
    private void MaxHeapify(int index, int lastLeaf) {
        int left = GetLeftChild(index);   
        int right = GetRightChild(index);  
        int largest;    
        
        if (left <= lastLeaf && comparisionArray[left] > comparisionArray[index])
          largest = left;  
        else
          largest = index;      
        
        if (right <= lastLeaf && comparisionArray[right] > comparisionArray[largest])
          largest = right; 

       
        if (largest != index) {
          Swap(index, largest);
          MaxHeapify(largest, lastLeaf);
        }

  }
    

  private void BuildMaxHeap(int lastLeaf) {
    int lastNonLeaf = (lastLeaf - 1) / 2; 
    for (int i = lastNonLeaf; i >= 0; i -= 1){
        MaxHeapify(i, lastLeaf);
    }
  }
  
  private void Swap(int index1, int index2){
        
        int temp = comparisionArray[index1];
        comparisionArray[index1] = comparisionArray[index2];
        comparisionArray[index2] = temp;


    }
  

  private int GetLeftChild(int index) {
    return 2 * index + 1;
  }
  
  
  private int GetRightChild(int index) {
    return 2 * index + 2;
  }
  
  public long GetTimeOfExecution(){
      return totalTime;
  }
  
  public String GetSortingType(){
      return "Heap Sort";
  }
  
  public int[] GetSorted(){
        return comparisionArray;
   }
}
