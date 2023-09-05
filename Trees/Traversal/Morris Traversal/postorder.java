// time: O(n)
//  space: o(1)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        while(curr != null){
            if(curr.right == null){
                ans.add(curr.val);
                curr = curr.left;
            }
            else{
                TreeNode node = curr.right;
                while(node.left != null && node.left != curr){
                    node = node.left;
                }

                if(node.left == null){
                    node.left = curr;
                    ans.add(curr.val);
                    curr = curr.right;
                }
                else{
                    node.left = null;
                    curr = curr.left;
                }
            }   
        }   

        Collections.reverse(ans);
        return ans;     
    }
}
