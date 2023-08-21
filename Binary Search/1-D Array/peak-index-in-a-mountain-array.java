class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int sI = 0;
        int eI = arr.length-1;

        // in the end both, sI and eI will be pointing to the larget element;
        while(sI != eI){
            int mid = sI + (eI-sI)/2;

            // In descending range
            // here I don't know elements that are before mid index are greater than arr[mid] or not so including mid as in eI, element at mid might be the greatest element.
            // end may be the ans, this is way end != mid - 1
            if(arr[mid] > arr[mid+1])
                eI = mid;
            else
                sI = mid + 1;
        }
        
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
     // or return end as both are =
        return eI;
    }
}
