//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i];
        }
        
        int rightMostSetBit = res&(-res);
        /*
            OR
            rightMostSetBit = res & ~(res-1);
        */
        int ans1=0, ans2=0;
        
        for(int i=0; i<nums.length; i++){
            if((rightMostSetBit&nums[i]) != 0)
                ans1 ^= nums[i];
            else
                ans2 ^= nums[i];
        }
        
        int ans[] = {Math.min(ans1, ans2), Math.max(ans1, ans2)};
        return ans;
    }
}
