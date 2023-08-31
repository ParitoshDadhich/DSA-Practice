// time o(n)
// space o(n)


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
