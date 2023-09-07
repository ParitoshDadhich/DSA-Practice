// RECURSIVE
// TIME: o(LOGN)
// SPACE: o(LOGN)


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int Key)
    {
        TreeNode node = new TreeNode(Key);
        return insertHelper(root, node);
    }
    
    private TreeNode insertHelper(TreeNode root, TreeNode node){
        if(root == null)
            return node;
            
        if(root.val > node.val)
            root.left = insertHelper(root.left, node);
        
        if(root.val < node.val)
            root.right = insertHelper(root.right, node);
            
        return root;
        
    } 
}

// ITERATIVE
// TIME: o(LOGN)
// SPACE: o(1)

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        TreeNode curr=root, prev=null;
        TreeNode node = new TreeNode(val);
        while(true){

            if(root == null){
                if(prev.val > val)
                    prev.left = node;
                else
                    prev.right = node;
                
                break;
            }
            else if(root.val > val){
                prev = root;
                root = root.left;
            }
            else{
                prev = root;
                root = root.right;
            }
        }

        return curr;
    }
}
