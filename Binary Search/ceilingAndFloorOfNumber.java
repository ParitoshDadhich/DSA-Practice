class Solution {
    public int searchInsert(int[] arr, int target) {
        int sI=0, eI=arr.length-1;

        while(sI <= eI){
            int mid = sI + (eI-sI)/2;

            if(arr[mid] > target){
                eI = mid-1;
            }
            else if(arr[mid] < target){
                sI = mid+1;
            }
            else{
                return mid;
            }
        }

        return sI;
        /*
        floor
        return eI;
        */
    }
}
