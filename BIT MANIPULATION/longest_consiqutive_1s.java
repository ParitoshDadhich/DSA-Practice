class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int n) {
        
        int max = 0;
        int count = 0;
        
        while(n != 0){
            while((n&1) == 1){
                count++;
                n >>= 1;
            }
            max = Math.max(max, count);
            count = 0;
            n >>= 1;
        }
        
        return max;
    }
}
