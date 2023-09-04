# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == right;
        
        if(left.val != right.val)
            return false;
        
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
```
