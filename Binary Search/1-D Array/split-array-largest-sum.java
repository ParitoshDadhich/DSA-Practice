// time: O(nlog(k)), k is the sum of all elements
// space: o(1)

class Solution {
    public int splitArray(int[] nums, int k) {

        // Our answer will be lie between start and end
        // with start: max of all numbers in an array -> when max possible partition can happen i.e. k = nums.length
        // with end: sum of all numbers in an array -> when min possible partition can happen i.e. k = 1;
        int end=0, start=0;
        for(int i: nums){
            start = Math.max(start, i);
            end += i;
        }

        while(start < end){
            // "mid" is the possible candidate for our answer; that is why I will take "mid" as a reference for partitioning
            int mid = start + (end-start)/2;

            int currentPartition = possiblePartitions(nums, mid);
            if(currentPartition <= k){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }

        // here I am returning "start" because in the end both "start" and "end" will be pointing at the same element and that would be our answer
        return start;
    }

    int possiblePartitions(int nums[], int mid){
        int pieces=1, sum=0;
        for(int i: nums){
            if(sum + i <= mid)
                sum += i;
            else{
                sum = i;
                pieces++;
            }
        }

        return pieces;
    }
}
