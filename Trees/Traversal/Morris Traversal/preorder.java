// time: O(n)
// space: O(1)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode node = curr.left;
                while(node.right != null && node.right != curr){
                    node = node.right;
                }
                if(node.right == null){
                    node.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                }
                else{
                    node.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}
