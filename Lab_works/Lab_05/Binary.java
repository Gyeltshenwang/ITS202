


public class Binary
{  
    public static int binarySearch(int arr[], int low, int high, int key)
    {  
        int mid = (low + high)/2;  
        while( low <= high )
        {  
            if ( arr[mid] < key )
            {  
                low = mid + 1;     
            }
            else if ( arr[mid] == key )
            {
                return mid;  
            }else
            {  
                high = mid - 1;  
            }  
            mid = (low + high)/2;  
        }  
        if ( low > high )
        {   
            return -1;
        }  
        return -1;
   }  
   public static void main(String args[])
   {  
        int arr[] = {10,20,30,40,50,60};  
        int key = 10;  
        int n=arr.length-1;  
        int index = binarySearch(arr,0,n,key);  
        System.out.println("The sorted array is: ");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nElement to be searched: "+key);
        if (index == -1)  
            System.out.println("not found!");  
        else 
            System.out.println("The Element is found at the index: "+index);  
   }  
}  
