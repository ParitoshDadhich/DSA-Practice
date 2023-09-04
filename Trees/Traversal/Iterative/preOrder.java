// time: O(n)
// space: O(n)
// auxillary space: o(h), h is the height of the stack

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node == null) continue;

          // pushing right node so that lefft node will be at the top of stack wrt a perticular sub tree of a binary tree
            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
            
            ans.add(node.val);
        } 

        return ans;
    }
}
