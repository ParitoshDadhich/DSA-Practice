class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
        // first take the XOR
        // by this we get to know which bits needs to get changed
        // then take the count of set bits
        int temp = a^b;
        int count=0;
        while(temp != 0){
            temp -= temp&(-temp);
            count++;
        }
        return count;
    }
    
    
}
