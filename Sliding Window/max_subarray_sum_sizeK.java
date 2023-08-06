// method 1 -> BRUTE FORCE
// time: o(n2) and space o(1)
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        long max = 0;
        for(int i=0; i<=n-k; i++){
            long sum = 0;
            for(int j=i; j<i+k; j++){
                sum += arr.get(j);
            }
            max = Math.max(sum, max);
        }
        
        return max;
    }
}

// method 2 -> SLIDING WINDOW
// time: O(n) and space o(1)

class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        long max = Integer.MIN_VALUE, sum = 0;
        int i=0, j=0;
        while(j <  n){
            sum += arr.get(j);
            
            // window of size k
            if(j-i+1 == k){
                max = Math.max(sum, max);
                // as we slide to next ele so removing first element of existing window
                sum = sum - arr.get(i);
                i++;
            }
            
            j++;
        }
        
        return max;
    }
}
