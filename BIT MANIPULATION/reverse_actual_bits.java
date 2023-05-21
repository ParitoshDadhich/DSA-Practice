class Solution
{
    public int reverseBits(int n)
    {
        int res = 0;
        while(n != 0){
            res <<= 1;
            if((n&1) == 1)
                res |= 1;
            
            n >>= 1;
        }
        return res;
    }
}
