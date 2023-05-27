// METHOD 1 -> Searching the missing array from 1 to n+1 in an array
// TIME: O(n^2)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // if size of nums is n then positive numbers that can be present from 1 to n+1
        for(int i=1; i<=n+1; i++){
            boolean flag = true;
            for(int j=0; j<n; j++){
                if(i == nums[j]){
                    flag = false;
                    break;
                }
            }

            if(flag)
                return i;
        }

        return 0;
    }
}

// METHOD 2 -> Sorting the array first and then scanning for the missing element
// TIME: O(nlogn)

// Naive way of writing
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        boolean isOnePresent = false;
        int onePos = -1;
        boolean isZeroPresent = false;
        int zeroPos = -1;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                isZeroPresent = true;
                zeroPos = i;
            }

            if(nums[i] == 1){
                isOnePresent = true;
                onePos = i;
                break;
            }
        }

        if(!isOnePresent)
            return 1;
        
        int i = (zeroPos!=-1 ? zeroPos : onePos);
        for(; i<n-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i]+1 != nums[i+1]){
                return nums[i]+1;
            }
        }
      
        // if(nums[i] == 1)
        //     return 2;
      
        if(i > 0 && nums[i-1] == nums[i])
            return nums[i]+1;

        return nums[n-1]+1;

    }
}


// Better way of writing
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int pos = 0;
        while(pos<n && nums[pos]<1){
            pos++;
        }

        int missingNumber = 1;
        for(int i = pos; i<n ;i++){
            if((i+1 < n) && nums[i] == nums[i+1]){
                continue;
            }
            if(missingNumber == nums[i]){
                missingNumber++;
            }
            else{
                return missingNumber;
            }
        }

        return missingNumber;
    }
}

// METHOD 3 -> Using hashmap for sorting elements
// Time: O(n)
// Space: O(n)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i: nums)
            map.put(i, true);
        
        for(int i=1; i<=n+1; i++){
            if(!map.containsKey(i))
                return i;
        }

        return 0;
    }
}

// METHOD 4 -> INPLACE HASHING
// TIME: O(n)
// space o(1)


class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

    /*
        nums[0] -> 1
        nums[1] -> 2;

        i = 20;
        nums[20] = 30

        I want -> nums[29] = 30;

        nums[3-1] != 3

        nums[3] = 4

        nums[4-1] = nums[3]

        if(nums[nums[i]-1] != nums[i])

    */

        int i=0;
        while(i<n){
            if(nums[i]-1 >= 0 && nums[i]-1 < n ){
                if(nums[nums[i]-1] != nums[i]){
                    swap(nums, nums[i]-1, i);
                }
                // here I am adding else because the moment above if block gets failed then we have to increase the value by 1 or else this while loop will become infinite loop
                // if I would not add else block here then, control will go to line 168 directly and value of i will not increase
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        
        int missingNumber = 1;
        for(int j=0; j<n; j++){
            if(nums[j] >= 0){
                if(missingNumber == nums[j]){
                    missingNumber++;
                } else{
                    return missingNumber;
                }
            }
        }

        return missingNumber;
    }

    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


// ANOTHER WAY OF IMPLEMENTING THE SAME CODE IN MORE SIMPLER APPROACH

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
      
        int i=0;
        while(i<n){
            if(nums[i]-1 >= 0 && nums[i]-1 < n  && nums[nums[i]-1] != nums[i]){
                    swap(nums, nums[i]-1, i);
            }
            else{
                i++;
            }
        }
      
        int missingNumber = 1;
        for(int j=0; j<n; j++){
            if(nums[j] >= 0){
                if(missingNumber == nums[j]){
                    missingNumber++;
                } else{
                    return missingNumber;
                }
            }
        }

        return missingNumber;
    }

    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

