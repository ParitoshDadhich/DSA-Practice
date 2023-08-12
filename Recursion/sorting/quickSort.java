
class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low >= high)
            return;
        
        int s = low;
        int e = high;
        int mid = low + (high-low)/2;
        int pivot = arr[mid];
        
        while(s <= e){
            while(arr[s] < pivot)
                s++;
            
            while(arr[e] > pivot)
                e--;
            
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                
                s++;
                e--;
            }
        }
        
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
