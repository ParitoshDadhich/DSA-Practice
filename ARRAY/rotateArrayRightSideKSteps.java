class Solution {
    public void rotate(int[] nums, int k) {
        for(int j=0; j<k; j++) {
            int lastElement = nums[nums.length-1];
            for(int i=nums.length-1; i>0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = lastElement;
        }
    }
}


// method 2
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        // storing last k elements;
        int temp[] = new int[k];
        for(int i=nums.length-k, t=0; i<nums.length; i++, t++) {
            if(i > 0)
                temp[t] = nums[i];
        }

        // shift elements to right from index 0 to nums.length-k-1;
        for(int i=nums.length-1; i>=k; i--) {
            nums[i] = nums[i-k];
        }

        // mapping elements temp to nums
        for(int i=0; i<k; i++){
            nums[i] = temp[i];
        }
    }
}
