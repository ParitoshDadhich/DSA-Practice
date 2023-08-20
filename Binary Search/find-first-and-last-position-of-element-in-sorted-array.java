// Iterative solution
class Solution {
public int[] searchRange(int[] nums, int target) {
    int ans[] = new int[2];
    Arrays.fill(ans, -1);
    
    int start = 0;
    int end = nums.length-1;
    
    // first occurence
    while(start <= end){
        int mid = start + (end-start)/2;
        if(target == nums[mid]){
            ans[0] = mid;
            end = mid - 1;
        }
        else if(target > nums[mid])
            start = mid + 1;
        else
            end = mid - 1;
    }
    
    // last ocurence
    // in the second half we need not to initialize start with 0 again
    end = nums.length - 1;
    while(start <= end){    
        int mid = start + (end-start)/2;
        if(target == nums[mid]){
            ans[1] = mid;
            System.out.println(mid);
            start = mid + 1;
        }
        else if(target > nums[mid])
            start = mid + 1;
        else
            end = mid - 1;
    }
    
    return ans;
}
}

// Recursive solution
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1, -1};
        if(ans[0] == -1)
            helper(nums, target, 0, nums.length-1, ans, true);
        if(ans[0] != -1)
            helper(nums, target, 0, nums.length-1, ans, false);
        
        return ans;
    }

    private void helper(int arr[], int target, int sI, int eI, int ans[], boolean searchFirst){
        if(sI > eI)
            return;
        
        int mid = sI + (eI-sI)/2;

        if(arr[mid] == target){
            if(searchFirst){
                ans[0] = mid;
                eI = mid-1;
            }
            else{
                ans[1] = mid;
                sI = mid+1;
            }
        }
        else if(arr[mid] > target){
            eI = mid-1;
        }
        else{
            sI = mid+1;
        }

        helper(arr, target, sI, eI, ans, searchFirst);
    }
}
