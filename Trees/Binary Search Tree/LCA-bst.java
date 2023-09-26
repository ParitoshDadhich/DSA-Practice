#### Recursive

# Complexity
- Time complexity: O(h), h is the hight of BST
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(h), h is the hight of BST
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        int currentNodeValue = root.val;
        // if both nodes lie in left subtree then go left or else go right;
        if(currentNodeValue > p.val && currentNodeValue > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(currentNodeValue < p.val && currentNodeValue < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If none of the roots lie on either side of the BST then we can say that this is the diversion point. This is our ans;
        return root;
    }
}
```

#### Iterative

# Complexity
- Time complexity: O(h), h is the hight of BST
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null) {
            int currentNodeValue = root.val;

            if(currentNodeValue > p.val && currentNodeValue > q.val) {
                root = root.left;
            } else if(currentNodeValue < p.val && currentNodeValue < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }
}
```
