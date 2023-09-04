// method 1
// using level order traversal
// Time o(n) and space o(n)

	
    class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                node = queue.poll();
                if(node == null) break;

                if(i == size-1)
                    ans.add(node.val);
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }

        return ans;
    }
}

// method 2
// using preorder traversal
// time o(n) and space o(h), h is the height of the binary tree


	class Solution {
        
    boolean check[];
    List<Integer> rightSideView(TreeNode root)
    { 
        if(root == null)
            return new ArrayList<>();
        
     
      int height = depth(root);
      check = new boolean[height];
      
      ArrayList<Integer> list = new ArrayList<>();
      leftView(root, list, 0);
      
      return list;
    }
    
    private void leftView(TreeNode root, ArrayList<Integer> list, int level){
        if(root == null) return;
        
        if(check[level] == false){
            list.add(root.val);
            check[level] = true;
        }
        
        // first traverse right and then left
        leftView(root.right, list, level+1);
        leftView(root.left, list, level+1);
        
        return;
    }
    
    private int depth(TreeNode root){
        if(root == null)
            return 0;
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
	}
