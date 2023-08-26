class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low >= high) return;
        
        int s=low, e=high;
        int mid = s + (e-s)/2;
        int pivot = arr[mid];
        while(s <= e){
            // check until value is less than pivot
            while(arr[s] < pivot)
                s++;
            // check until value is greater than pivot
            while(arr[e] > pivot)
                e--;
            
            if(s <= e){
                swap(arr, s, e);
                s++;
                e--;
            }
        }
        
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
