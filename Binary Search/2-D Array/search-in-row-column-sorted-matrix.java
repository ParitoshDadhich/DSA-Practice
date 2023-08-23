// time o(m+n)
// space o(1)

class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int arr[][], int n, int m, int x) 
	{  
	    int lowerBound=0, upperBound=m-1;
	    while(lowerBound < n && upperBound >= 0){
	        if(arr[lowerBound][upperBound] == x )
	           // return new int[]{lowerBound, upperBound};
	           return true;
	        
	        else if(arr[lowerBound][upperBound] < x)
	            lowerBound++;
	        else
	            upperBound--;
	    }
	    
	    return false;
	} 
} 
