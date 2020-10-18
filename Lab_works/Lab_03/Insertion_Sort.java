public class Insertion_Sort
{  
    public static void insertionSort(int array[]) 
    {  
        int n = array.length;  
        for (int j = 1; j < n; j++) 
        {  
            int temp = array[j]; 

            int previous_element = j-1; 

            while ( (previous_element > -1) && ( array [previous_element] > temp) ) 
            {  
                array [previous_element+1] = array [previous_element];  
                previous_element--;  
            }  
            array[previous_element+1] = temp;  
        }  
    }  
       
    public static void main(String args[])
    {    
        int[] arr1 = {9,14,3,2,43,11,58,22};  

        System.out.println("Before Insertion Sort"); 

        for(int previous_element:arr1)
        {    
            System.out.print(previous_element+" ");    
        }    
        System.out.println();    
            
        insertionSort(arr1);//sorting array using insertion sort    
           
        System.out.println("After Insertion Sort"); 

        for(int previous_element:arr1)
        {    
            System.out.print(previous_element+" ");    
        }    
    }    
}  
