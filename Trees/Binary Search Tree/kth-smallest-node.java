
class Pair {
    int count;
    int val;
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Pair p = helper(root, k, new Pair());
        System.out.println(p.count);
        return p.val;
    }

    private Pair helper(TreeNode root, int k, Pair p){
        if(root == null){
            return p;
        }

        
        Pair p1 = helper(root.left, k, p);
        
        if(p1.count < k) {
            p1.count++;
            p1.val = root.val;
        }
      // If we have found the kth smallest then return
        if(p1.count == k) {
            return p1;
        }
        
        return helper(root.right, k, p1);
    }
}
