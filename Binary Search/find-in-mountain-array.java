/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);

        int leftIndex = orderAgnosticBSearch(mountainArr, target, 0, peakIndex, true);
        int rightIndex = orderAgnosticBSearch(mountainArr, target, peakIndex+1, mountainArr.length()-1, false);

        if(leftIndex != -1 && rightIndex != -1)
            return Math.min(leftIndex, rightIndex);
        
        return leftIndex != -1 ? leftIndex : rightIndex;
    }

    private int findPeak(MountainArray mountainArr){
        int sI=0, eI=mountainArr.length()-1;

        while(sI != eI){
            int mid = sI + (eI-sI)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1))
                eI = mid;
            else
                sI = mid+1;
        }

        return sI;
    }

    private int orderAgnosticBSearch(MountainArray mountainArr, int target, int sI, int eI, boolean searchAsec){
        while(sI <= eI){
            int mid = sI + (eI-sI)/2;
            
            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                if(searchAsec){
                    eI = mid-1;
                }
                else{
                    sI = mid+1;
                }
            }
            else{
                if(searchAsec){
                    sI = mid+1;
                }
                else{
                    eI = mid-1;
                }
            }
        }

        return -1;
    }
}
