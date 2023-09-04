// With 2 stack 
// time o(n)
// space o(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            if(root == null) continue;

            st2.push(root);
            if(root.left != null) 
                st1.push(root.left);
            if(root.right != null)
                st1.push(root.right);
        }

        List<Integer> ans = new ArrayList<>();
        while(!st2.isEmpty())
            ans.add(st2.pop().val);
        
        return ans;
    }
}


// with 1 stack
// time: o(n)
// aux space: O(h), h is the height of the tree
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        while(root != null || !st.isEmpty()){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                TreeNode node = st.peek().right;
                if(node == null){
                    node = st.pop();
                    ans.add(node.val);
                    // moving backwards
                    while(!st.isEmpty() && node == st.peek().right){
                        node = st.pop();
                        ans.add(node.val);
                    }
                }
                else{
                    root = node;
                }
            }
        }

        return ans;
    }
}
