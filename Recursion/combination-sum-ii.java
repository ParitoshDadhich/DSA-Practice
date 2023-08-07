class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    private void helper(int arr[], int target, int sI, ArrayList<Integer> list){
        if(target == 0){
            // if(!ans.contains(list))  -> commenting this and introducting skipping duplicates, since checking in an answer list is the expensive operation;
            ans.add(new ArrayList<>(list));
            return;
        }

        if(sI == arr.length || arr[sI] > target) return;

        // selecting an element and then backtracking
        list.add(arr[sI]);
        if(!ans.contains(list))
            helper(arr, target-arr[sI], sI+1, list);
        list.remove(list.size()-1);
    
        // skipping duplicates
        while (sI + 1 < arr.length && arr[sI] == arr[sI + 1])
            sI++;

        helper(arr, target, sI+1, list);

        return;
    }
}
