// method 1
// Time: O(number of set bits)
class Solution {
    static int setBits(int n) {
         System.out.println("Binary is " + Integer.toBinaryString(n));
        int count = 0;
        while(n != 0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}

// method2
// Time: O(logN)
class Solution {
    static int setBits(int n) {
        int count = 0;
        while(n != 0){
            if((n&1)==1)
                count++;
            
            n >>= 1;
        }
        return count;
    }
}

// method 3
// Time: O(number of set bits)
class Solution {
    static int setBits(int n) {
        int count = 0;
        while(n != 0){
            n = n - (n&(-n));
            count++;
        }
        return count;
    }
}
