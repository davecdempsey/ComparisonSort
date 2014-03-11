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
public class InsertionSort extends ComparisonSort{
    
    private int[] comparisionArray;
    
    public InsertionSort(int[] comparisionArray, int leftIndex, int rightIndex){
        this.comparisionArray = comparisionArray;
        
        Sort(comparisionArray, leftIndex, rightIndex);
    }
 
    private void Sort(int[] sequence, int leftIndex, int rightIndex){
        for(int i = leftIndex + 1; i < rightIndex + 1; i += 1){
            while(i > leftIndex){
                if(sequence[i] < sequence[i - 1]){
                    sequence = Swap(i, i - 1, sequence);
                    i -= 1;
                }
                else{
                    break;
                }
            }
        }
    }
    
    private int[] Swap(int index1, int index2, int[] sequence){
        
        int temp = sequence[index1];
        sequence[index1] = sequence[index2];
        sequence[index2] = temp;

        return sequence;
    }
    
    public int[] GetSortedArray(){
        return comparisionArray;
    }
}
