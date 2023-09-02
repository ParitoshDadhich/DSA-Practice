Complexity
Time complexity: O(n)
Space complexity: O(h), h is the height of the binary tree
  
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        if(root == p || root == q)
            return root;
        
        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        // if both leftSubtree and rightSubtree are null, it means root is not the ancestor
        if(leftSubtree == null && rightSubtree == null)
            return null;
        // if both are not null then root is the ancestor -> it signifies both are originated from root only;
        else if(leftSubtree != null && rightSubtree != null)
            return root;
        // current root is not the ancestor so pass the value and we will find ancestor in other subsequent cases
        return leftSubtree == null ? rightSubtree : leftSubtree;
    }
}
