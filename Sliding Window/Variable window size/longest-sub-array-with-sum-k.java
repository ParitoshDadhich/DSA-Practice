// method 1
// time : O(n^2)
// space: O(1)

class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int sum) {
        //Complete the function
        int max = 0;
        for(int i=0; i<n; i++){
            int tempSum = 0;
            for(int j=i; j<n; j++){
                tempSum += arr[j];
                if(tempSum == sum){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}

// method 2
// time: O(n)
// space: O(1)
//   THIS APPROACH WILL ONLY VALID FOR +VE NUMBERS


class Solution{
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        int max = 0;
        int i=0, j=0, tempSum=0;
        while(j < n){
            tempSum += arr[j];
            if(tempSum < k){
                // j++
            }
            else if(tempSum == k){
                max = Math.max(max, j-i+1);
                    // j++;
            }                
            // we will be keep on subtracting until tempSum become less than or equal to k
            else if(tempSum > k){
                while(tempSum > k){
                    tempSum = tempSum - arr[i];
                    i++;
                }
                
                // while subtracting tempSum by arr[i], one codition will come when TempSum == k, consider eg: [1 4 3 3 3 7], k = 16
                if(tempSum == k){
                    max = Math.max(max, j-i+1);
                }
                
                // j++;
            }

            // Since in every condition I am incrementing j by 1 so commenting there and adding here
            j++;
        }
        return max;
    }
}



// another way of writing the above approach
class Solution{
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        int max = 0;
        int i=0, j=0, tempSum=0;
        while(j < n){
            tempSum += arr[j];
            
            // we will be keep on subtracting until tempSum become less than or equal to k
            if(tempSum > k){
                while(i < n && tempSum > k){
                    tempSum = tempSum - arr[i];
                    i++;
                }
            }
            
            if(tempSum == k){
                max = Math.max(max, j-i+1);
                    j++;
            }    
            else if(tempSum < k){
                j++;
            }
        }
        return max;
    }
}
