class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    public void helper(int arr[], int target, int sI, ArrayList<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(sI == arr.length) return;

        // picking an element
        if(arr[sI] <= target){
            list.add(arr[sI]);
            helper(arr, target-arr[sI], sI, list);
            list.remove(list.size()-1);
        }

        // not picking an element
        helper(arr, target, sI+1, list);

        return;
    }
}
