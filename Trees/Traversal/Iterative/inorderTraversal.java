class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        TreeNode node = root;
        while(node != null || !st.isEmpty()){
            while(node != null){
                st.add(node);
                node = node.left;
            }
            node = st.pop();
            list.add(node.val);
            node = node.right;
        }        
        return list;
    }
}
