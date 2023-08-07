Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(2N)

class Solution{
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        helper(arr, 0, 0);
        return list;
    }
    
    void helper(ArrayList<Integer> arr, int sI, int sum){
        if(sI == arr.size()){
           list.add(sum);
           return;
        }
        
        helper(arr, sI+1, sum+arr.get(sI));
        helper(arr, sI+1, sum);
        
        return;
    }
}
