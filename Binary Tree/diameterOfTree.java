/*
  1. longest path between two nodes;
  2. Does not necessary pass between root, we can get longest path either in left subtree or in right subtree or in the combination of left subtree and right subtree.
*/

#### method 1 -> DFS
# Complexity
- Time complexity: o(n^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h), h is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int diameter){
        if(root == null)
            return diameter;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // leftHeight+rightHeight -> diameter that is passing through the current root;
        diameter = Math.max(diameter, leftHeight+rightHeight);

        // Diameter would be max(leftSubtree, rightSubtree, passing through current root);
        return Math.max(diameter, Math.max(helper(root.left, diameter), helper(root.right, diameter)));
    }

    private int height(TreeNode node){
        if(node == null)
            return 0;
        
        return 1 + Math.max(height(node.left), height(node.right));
    }

}
```
#### method 2 -> Using Pair class
# Complexity
- Time complexity: o(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h), h is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        Pair ans = helper(root);
        return ans.diameter;
    }

    private Pair helper(TreeNode root){
        if(root == null){
            return new Pair();
        }

        // calculating diameter and height for left subtree and right subtree respectively
        Pair leftPart = helper(root.left);
        Pair rightPart = helper(root.right);

        Pair ans = new Pair();

        int op1 = leftPart.height + rightPart.height;
        int op2 = leftPart.diameter;
        int op3 = rightPart.diameter;

        ans.height = Math.max(leftPart.height, rightPart.height) + 1;
        ans.diameter = Math.max(op1, Math.max(op2, op3));

        return ans;
    }
}

class Pair{
    int height;
    int diameter;
}
```
#### method 3 -> using default variable
# Complexity
- Time complexity: o(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h), h is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        maxDiameter = Math.max(maxDiameter, lHeight+rHeight);
        return 1 + Math.max(lHeight, rHeight);
    }
}
```
