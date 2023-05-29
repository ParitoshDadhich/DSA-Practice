// METHOD 1
// SORT THE ARRAY ->nlgon

// method 2
// keep three counter for 0, 1, and 2 
// and apply 3 for loops


// METHOD 3
// TIME O(N)
// SPACE O(1)

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        int start = 0;
        int end = n-1;
        int t = 0;
        
        while(t<=end){
            if(a[t] == 0){
                swap(a, start, t);
                start++;
                t++;
            }
            else if(a[t] == 2){
                swap(a, end, t);
                end--;
            }
            else{
                t++;
            }
        }
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
