// method 1
// time O(1)
class Solution {
    public int xorOperation(int n) {
        if(n%4 == 0)
            return n;
        else if(n%4 == 1)
            return 1;
        else if(n%4 == 2)
            return n+1;
        else
            return n+1;
    }
}


// method 2
// Time: O(n)

// take xor of all elements from o to n;
