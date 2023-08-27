// Time: o(n)
// space: o(h), h is the height of the tree

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;    
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;
        
        int lHeight = height(root.left);
        if(lHeight == -1)
            return -1;
        int rHeight = height(root.right);
        if(rHeight == -1)
            return -1;

        if(Math.abs(lHeight-rHeight) > 1)
            return -1;        

        return 1 + Math.max(lHeight, rHeight);
    }
}


// time: O(n^2)
// space: o(h), h is the height of the tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if(Math.abs(lHeight-rHeight) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
