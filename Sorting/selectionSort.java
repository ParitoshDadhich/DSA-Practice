// Iterative approach
class Solution
{
	void selectionSort(int arr[], int n)
	{
	    int index = -1;
	    for(int i=0; i<n; i++){
	        int min = Integer.MAX_VALUE;
	        for(int j=i; j<n; j++){
	            if(arr[j] < min){
	                min = arr[j];
	                index = j;
	            }
	        }
	        if(min != Integer.MAX_VALUE){
	            swap(arr, index, i);
	        }
	    }
	}
	
	void swap(int arr[], int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}


// Recursive approach

class Solution
{
	void selectionSort(int arr[], int n)
	{
	    if(n == 0) return;
	       
	    int maxIndex = maxIndex(arr, n-1);
	    
	    swap(arr, maxIndex, n-1);
	    
	    selectionSort(arr, n-1);
	}
	
	int maxIndex(int arr[], int n){
	    if(n == 0){
	        return n;
	    }
	    
	    int index = maxIndex(arr, n-1);
	    
	    if(arr[index] < arr[n]){
	        return n;
	    }
	    else{
	        return index;
	    }
	}
	
	void swap(int arr[], int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}


// Recursive approach -> pattern
class Solution
{
	void selectionSort(int arr[], int n)
	{
	    helper(arr, n, 0, 0);
	}

    void helper(int arr[], int r, int c, int maxIndex){
        if(r == 0) return;
        
        if(r > c){
            if(arr[c] >= arr[maxIndex])
                helper(arr, r, c+1, c);
            else
                helper(arr, r,  c+1, maxIndex);
        }
        else{
            swap(arr, maxIndex, r-1);
            helper(arr, r-1, 0, 0);
        }
    }
	
	void swap(int arr[], int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}
