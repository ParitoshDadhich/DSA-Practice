
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // reverse an array and xor with 1
        for(int arr[]: image){
            for(int i=0; i<(image[0].length+1)/2; i++){
                int temp = 1^(arr[i]);
                arr[i] = 1^arr[image[0].length-i-1];
                arr[image[0].length-i-1] = temp;
            }
        }

        return image;
    }
}
