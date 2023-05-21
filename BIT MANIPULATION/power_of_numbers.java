class Solution
{
        
    long power(int n,int r)
    {
     
     long ans = 1;
     long base = n;
     long power = r;
     while(power != 0){
         if((power&1) == 1){
             ans = (ans*base)%1000000007;
         }
         base = (base*base)%1000000007;
         power = power>>1;
     }   
        return ans;
    }

}
