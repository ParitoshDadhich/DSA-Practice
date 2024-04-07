public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        int max[] = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int min[] = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        helper(a, 0, min, max);

        return new int[] {max[1], min[1]};
    }

    static void helper(int arr[], int startIndex, int min[], int max[]) {
        if(startIndex == arr.length) {
            return;
        }

        // compairing max
        if(arr[startIndex] > max[0]) {
            max[1] = max[0];
            max[0] = arr[startIndex];
        } else if(arr[startIndex] > max[1] && arr[startIndex] != max[0]) {
            max[1] = arr[startIndex];
        }

        // compairing min
        if(arr[startIndex] < min[0]) {
            min[1] = min[0];
            min[0] = arr[startIndex];
        } else if(arr[startIndex] < min[1] && min[0] != arr[startIndex]) {
            min[1] = arr[startIndex];
        }

        helper(arr, startIndex+1, min, max);
    }
}
