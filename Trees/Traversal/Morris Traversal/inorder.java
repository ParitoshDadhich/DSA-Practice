// time o(n)
// space o(1)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<>();
        while(cur != null){
            // if the left node is null then add value to answer list and move towards right
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }
            else{
                // if left node is not null then 
                /*
                    take a temp node and move to the right most node in left sub tree and point it to current root.
                    This pointing will help to go to the current root node once traversing is done. Since we are not using recursion or not keeping stack/any other data structure, we do not have a way to go back to the current root. that is why we are pointing to current root in such way. 
                    This is also known as CREATING A THREAD. 
                    Due to this way of solving this question, we are creating -> threaded binary tree
                */
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur){
                    node = node.right;
                }

                // pointing to current root and then only moving towards left node
                if(node.right == null){
                    node.right = cur;
                    cur = cur.left;
                }
                // if the node.right is pointing to any root / current root then we need to break the pointing/break the thread. Or else it will creating a infinite loop and we will not be able to move right sub tree.
                // breaking the thread and moving to right subtree
                else{
                    node.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return ans;
    }
}
