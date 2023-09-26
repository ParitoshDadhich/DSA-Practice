// METHOD 1
// TIME: O(N2)
// SPACE: O(H), H is the height of the BST

class Solution {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(root.left != null) {
            if(root.val <= max(root.left)) {
                return false;
            }
        }

        if(root.right != null) {
            if(root.val >= min(root.right)) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int max(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    private int min(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.val, Math.min(min(root.left), min(root.right)));
    }
}



// METHOD 2
// TIME: O(N)
// SPACE: O(H), H is the height of the tree

/*
Idea of this approach is:
    Both left subtree nodes and right subtree nodes should lie within the range.
    If any nodes violetes the condition then we return false;
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) {
            return true;
        }

        if(root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
