# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if(root == null || (root.left == null && root.right == null))
             return 0;
            
        Map<TreeNode, TreeNode> childParent = new HashMap<>();
        TreeNode targetNode = makeChildParentRelation(root, start, childParent);
        if(targetNode == null) 
            return 0;
        return burnTree(targetNode, childParent);
    }

    private int burnTree(TreeNode root, Map<TreeNode, TreeNode> childParent){
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(root, true);
        queue.add(root);
        int minTime = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                // checking left node is visited or not, if not then burn the node
                if(node.left != null && visited.get(node.left) == null){
                    flag = true;
                    visited.put(node.left, true);
                    queue.add(node.left);
                }
                // checking right node is visited or not, if not then burn the node
                if(node.right != null && visited.get(node.right) == null){
                    flag = true;
                    visited.put(node.right, true);
                    queue.add(node.right);
                }
                // checking node's parent is visited or not, if not then burn the node
                TreeNode parentNode = childParent.get(node);
                if(parentNode != null && visited.get(parentNode) == null){
                    flag = true;
                    visited.put(parentNode, true);
                    queue.add(parentNode);
                }
            }

            // increast the time, if in any of the above 3 cases we burn the node;
            // all the nodes (parents' node(upward), left node and right node) burn together;
            // NOTE:
            // LEAF NODES will not be able to burn any adajecent node because their parents are already visited and they dont have any children. That's is why we will not increment time in case of leaf nodes.
            if(flag)
                minTime++;
        }
        
        return minTime;
    }

    private TreeNode makeChildParentRelation(TreeNode root, int start, Map<TreeNode, TreeNode> childParent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode targetNode = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                // finding the targetNode;
                if(node.val == start){
                    targetNode = node;
                }
                if(node.left != null){
                    childParent.put(node.left, node);
                    queue.add(node.left);
                }
                if(node.right != null){
                    childParent.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }

        return targetNode;
    }

}
```
