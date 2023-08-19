// Iterative approach
class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        int currentLastIndex = n-1;
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){
                if(j+1 < n && arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }
    
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


// Recursive approach
class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        helper(arr, n, 0);
    }
    
    static void helper(int arr[], int r, int c){
        if(r == 0)
            return;
        
        if(r > c){
            if(c+1 < r && arr[c] > arr[c+1])
                swap(arr, c, c+1);
            helper(arr, r, c+1);
        }
        else{
            helper(arr, r-1, 0);
        }
    }
    
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
