class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(root.val == key) {
            return deleteNode(root);
        }

        TreeNode rootReference = root;
        // searching for a node to be deleted and its prev node
        Pair pair = searchNode(root, key, new Pair());

        // applying deleting node logic
        if(pair != null) {
            if(pair.prev.val > pair.node.val) {
                pair.prev.left = deleteNode(pair.node);
            } else{
                pair.prev.right = deleteNode(pair.node);
            }
        }

        return rootReference;
    }

    private TreeNode deleteNode(TreeNode root) {
        if(root == null) {
            return root;
        }
        if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        }

        TreeNode rightChild = root.right;
        TreeNode leftChileRightMostNode = rightMostNode(root.left);
        
        leftChileRightMostNode.right = rightChild;
        
        return root.left;
    }

    private TreeNode rightMostNode(TreeNode root){
        if(root.right == null) {
            return root;
        }

        return rightMostNode(root.right);
    }

    private Pair searchNode(TreeNode root, int key, Pair pair){
        if(root == null) {
            return null;
        }

        if(root.val == key) {
            pair.node = root;
            return pair;
        }

        if(root.val > key) {
            pair.prev = root;
            return searchNode(root.left, key, pair);
        } else {
            pair.prev = root;
            return searchNode(root.right, key, pair);
        }
    }
}

class Pair {
    TreeNode prev;
    TreeNode node;
}
