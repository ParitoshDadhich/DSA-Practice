// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90,
                            100, 130, 140, 160, 170};
        System.out.println(searchElement(arr, 140));
    }
    
    static int searchElement(int arr[], int target){
        int start = 0;
        int end = 1;
        
        while(arr[end] < target){
            start = end;
            end = end*2;
        }
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                end = mid-1;
            else 
                start = mid+1;
        }
        
        return -1;
    }
}
