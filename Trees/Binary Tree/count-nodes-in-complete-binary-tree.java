# Complexity
- Time complexity: O(logn)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(h), h = logn -> height of the complete binary tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        // traversing till the last left node of binary tree
        int lh = leftHeight(root);
        // traversing till the last right node of binary tree
        int rh = rightHeight(root);
    
        if(lh == rh)
            return (int)Math.pow(2, lh) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode root){
        if(root == null)
            return 0;
        return 1 + leftHeight(root.left);
    }

    private int rightHeight(TreeNode root){
        if(root == null)
            return 0;
        return 1 + rightHeight(root.right);
    }
}
```
