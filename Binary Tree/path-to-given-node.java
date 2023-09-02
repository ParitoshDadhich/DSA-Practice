// time: o(n)
// space: o(k), k is the number of nodes in path

public class Solution {
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(A, B, list);
        
        int ans[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    private boolean helper(TreeNode root, int b, ArrayList<Integer> list){
        if(root == null)
            return false;
        
        list.add(root.val);
        if(root.val == b){
            return true;
        }
        
       if(helper(root.left, b, list) || helper(root.right, b, list))     
            return true;
        
        list.remove(list.size()-1);
        
        return false;
    }
}
