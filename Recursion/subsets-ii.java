class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    public void helper(int arr[], int sI, ArrayList<Integer> list){
        if(sI == arr.length){
            if(!ans.contains(list))
                ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[sI]);
        helper(arr, sI+1, list);
        list.remove(list.size()-1);
        helper(arr, sI+1, list);

        return;
    }

}
