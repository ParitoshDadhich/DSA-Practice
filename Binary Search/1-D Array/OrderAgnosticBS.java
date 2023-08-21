// this algo will search whether the elements are sorted in ascending order or descending order
// TIME: O(logn)
// SPACE: O(1)

class Solution {
    int binarysearch(int arr[], int n, int key) {
        boolean isAsec = arr[0] < arr[n-1];
        int sI=0, eI=n-1;
        
        while(sI <= eI){
            int mid = sI + (eI-sI)/2;
            
            if(arr[mid] > key){
                if(isAsec){
                    eI = mid-1;
                }
                else{
                    sI = mid+1;
                }
            }
            else if(arr[mid] < key){
                if(isAsec){
                    sI = mid+1;
                }
                else{
                    eI = mid-1;
                }
            }
            else{
                return mid;
            }
        }
        
        return -1;
    }
}
