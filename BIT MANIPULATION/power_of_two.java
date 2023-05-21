// method 1
class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        
        if (n==0) return false;
        
        return (n&(n-1)) == 0;
        
    }
    
}


// method 2
class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        
        int counter = 0;
        while(n!= 0){
            if((n&1) != 0){
                counter++;
            }
            n = n >> 1;
        }
        
        return counter == 1;
    }
    
}
