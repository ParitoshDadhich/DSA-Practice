// METHOD 1

class Solution {
    static Long nthMagicNumber(int N) {
       Long ans = 0L;
       int bit = 1;
       for(int i=1; i<32; i++){
           if((N&bit) != 0){
               ans += (long)Math.pow(5, i);
           }
           
           bit = bit<<1;
       }
       return ans;
    }
}

// method 2
static int nthMagicNo(int n)
  {
     int pow = 1, answer = 0;
  
     // Go through every bit of n
     while (n != 0)
     {
       pow = pow*5;
  
       // If last bit of n is set
       if ((int)(n & 1) == 1)
         answer += pow;
  
       // proceed to next bit
       // or n = n/2
       n >>= 1; 
     }
     return answer;
  }
