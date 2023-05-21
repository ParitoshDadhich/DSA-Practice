
// method 1
// time o(total bits in n)

class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n > 0){
            if((n & 1) == 1)
                res++;
            
            n = n>>1;
        }
        return res;
    }
}



// method 2
// time o(total bits in n)

class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n > 0){
            if(n%2 != 0)
                res++;
            
            n = n/2;
        }
        return res;
    }
}





// method 3
// using Brion kerningam's Algo
// time O(total number of set bits in n)


class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n != 0){
             n = (n & (n-1));
                res++;
        }
        return res;
    }
}

// method 4
// time O(total number of set bits in n)


class Solution {
    static int setBits(int n) {
        int res = 0;
        while(n != 0){
            // by this we are removing right most set bit
            // 110 -> 100, after the operation
             n = n - (n&(-n));
                res++;
        }
        return res;
    }
}


 
