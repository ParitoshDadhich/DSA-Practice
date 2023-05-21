public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int t = 1;
        int res = 0, k=0;
        for(int i=31; i>=0; i--){
            if((n&t) == 1){
                t = t<<i;
                k = t;
            }
            
            res = res | k;
            t = 1;
            n = n>>1;
        }

        return res;
    }
}

// ANOTHER WAY OF WRITING ABOVE CODE

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, lsb=0;
        for(int i=31; i>=0; i--){
            lsb = n & 1;
            lsb <<= i;
            res |= lsb;
            n >>= 1;
        }

        return res;
    }
}
