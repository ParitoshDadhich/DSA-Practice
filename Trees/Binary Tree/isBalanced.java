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


// method 3 -> using pair class
// time -> o(n)
// space -> o(h)
 

class Solution {
    
    static class Pair{
        int height;
        boolean balance;
    }
    
    
	public boolean isBalanced(TreeNode root) {
        return helper(root).balance;
    }
    
	private Pair helper(TreeNode root) {
        if(root == null){
            Pair ans = new Pair();
            ans.height = 0;
            ans.balance = true;
            
            return ans;
        }
        
        Pair ans = new Pair();
        
        Pair temp1 = helper(root.left);
        Pair temp2 = helper(root.right);
        
        ans.height = Math.max(temp1.height, temp2.height) + 1;
        ans.balance = ( Math.abs(temp1.height - temp2.height) > 1 || temp1.balance == false || temp2.balance == false) ? false : true;
        
        return ans;
        
    }
}
