// IN THIS PROBLEM, DUBLICATES WILL BE PRESENT

class Solution {
    public boolean search(int[] nums, int target) {
        /*
            1. Find pivot
            2. apply binary search 0 to pivot-1
            3. then pivot+1 to nums.length-1;
        */

        int pivotIndex = findPivot(nums);
        System.out.println(pivotIndex);
        // if nums is sorted then simply apply bSearch from 0 to nums.length-1
        if(pivotIndex == -1)
            return bSearch(nums, target, 0, nums.length-1);
        
        // if pivotIndex value is the target value;
        if(nums[pivotIndex] == target)
            return true;

        boolean leftHalf = bSearch(nums, target, 0, pivotIndex-1);
        
        if(leftHalf == false)
            return bSearch(nums, target, pivotIndex+1, nums.length-1);
        
        return leftHalf;
    }

    private int findPivot(int nums[]){
        // pivot element i.e. max element
        int sI=0, eI=nums.length-1;

        while(sI <= eI){
            int mid = sI + (eI-sI)/2;

            if(mid+1 <= eI && nums[mid] > nums[mid+1])
                return mid;
            else if(mid-1 >= sI && nums[mid] < nums[mid-1])
                return mid-1;
            // in case of duplicate elements -> we will skip duplicates
            else if(nums[mid] == nums[sI] && nums[mid] == nums[eI]){
                // what if the start element is the pivot element
                if(sI < eI && nums[sI] > nums[sI+1])
                    return sI;
                sI++;           // skipping duplicates

                // what if the end element is the pivot element
                if(eI > sI && nums[eI] < nums[eI-1])
                    return eI-1;
                eI--;           // skipping duplicates
            }

            else if(nums[sI] < nums[mid] || (nums[sI] == nums[mid] && nums[mid] > nums[eI]))
                sI = mid+1;
            else
                eI = mid-1;
        }

        return -1;
    }

    private boolean bSearch(int[] nums, int target, int sI, int eI){
        while(sI <= eI){
            int mid = sI + (eI-sI)/2;

            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target)
                eI = mid-1;
            else
                sI = mid+1;
        }

        return false;
    }
}
