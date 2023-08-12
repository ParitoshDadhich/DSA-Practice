# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(K), where k is the size of window
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0, max=0;
        int i=0, j=0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();

        while(j < n){
            /*
            removing all values till we remove the duplicate element that is present in the window
            consider this test case [9,18,13,10,13,9,19,2,1,18], k = 5
            */
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            // window size reached
            if(j-i+1 == k){
                max = Math.max(sum, max);
                set.remove(nums[i]);
                sum = sum - nums[i];
                i++;
            }

            j++;
        }

        return max;
    }
}
```
