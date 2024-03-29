// Iterative solution

class Solution {
    public int search(int[] nums, int target) {
        /*
            1. Find pivot element index, here pivot element is the max value element of an array
            2. apply binary search 0 to pivotIndex
            3. apply again binary search pivotIndex+1 to nums.length-1;
        */

        // finding pivot element
        int sI=0, eI=nums.length-1;
        int pivotIndex = findPivot(nums);
        
        // when array is alreay sorted
        if(pivotIndex == -1)
            return binarySearch(nums, 0, eI, target);

        // if my target element is the pivot element
        if(nums[pivotIndex] == target)
            return pivotIndex;
        int leftHalf = binarySearch(nums, sI, pivotIndex-1, target);
        if(leftHalf == -1)
            return binarySearch(nums, pivotIndex+1, eI, target);
        
        return leftHalf;
    }

    private int findPivot(int arr[]){
        int sI=0, eI=arr.length-1;

        while(sI <= eI){
            int mid = sI + (eI-sI)/2;

            if(mid+1 <= eI && arr[mid] > arr[mid+1])
                return mid;
            else if(mid-1 >= sI && arr[mid] < arr[mid-1])
                return mid-1;
            else if(arr[sI] > arr[mid])
                eI = mid-1;
            else
                sI = mid+1;
        }

        return -1;
    }

    private int binarySearch(int nums[], int sI, int eI, int target){

        while(sI <= eI){
            int mid = sI + (eI-sI)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                eI = mid-1;
            else
                sI = mid+1;
        }

        return -1;
    }
}


// Recursive solution
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }

    private int helper(int nums[], int target, int sI, int eI){
        if(sI > eI)
            return -1;
        
        int mid = sI + (eI-sI)/2;

        if(nums[mid] == target){
            return mid;
        }

        // Check if the left subarray is sorted
        else if(nums[sI] < nums[mid]){
            if(nums[sI] <= target && target <= nums[mid])    // Search in the left subarray
                return helper(nums, target, sI, mid-1);
            else                                            // Search in the right subarray
                return helper(nums, target, mid+1, eI);
        }

        // Check if the right subarray is sorted
        else{
            if(mid+1 <= eI && nums[mid+1] <= target && target <= nums[eI])  // Search in the right subarray
                return helper(nums, target, mid+1, eI);
            else                                                            // Search in the left subarray
                return helper(nums, target, sI, mid-1);
        }
    }
}
