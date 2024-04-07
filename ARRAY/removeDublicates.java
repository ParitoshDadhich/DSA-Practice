class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int len = nums.length;
        int i=0;
        while(i<len){
            count++;
            int temp = i+1;
            while(temp < len && nums[i] == nums[temp]){
                nums[temp] = Integer.MIN_VALUE;
                temp++;
            }
            i = temp;
        }

        int k = 1;
        for(i=1; i<len; i++){
            if(nums[i] != Integer.MIN_VALUE && k < len){
                nums[k] = nums[i];
                k++;
            }
        }
        return count;
    }
}
