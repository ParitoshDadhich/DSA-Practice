

class Solution
{
    static void merge(int arr[], int start, int mid, int end)
    {
         int i = start;
         int j = mid+1;
         int k = 0;
         int a[] = new int[end-start+1];
         while(i <= mid && j<= end){
             if(arr[i] <= arr[j]){
                a[k++] = arr[i++];
             }
             else{
                 a[k++] = arr[j++];
             }
         }
         
         while(i<=mid){
            a[k] = arr[i];
            k++;
            i++;
         }
         while(j<=end){
            a[k] = arr[j];
            k++;
            j++;
         }
            
        
         for(i=0; i<a.length; i++)
            arr[i+start] = a[i];
         
    }
    static void mergeSort(int arr[], int start, int end)
    {
        if(start == end) return;
        int mid = (int)(start + (end-start)/2);
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }  
}
