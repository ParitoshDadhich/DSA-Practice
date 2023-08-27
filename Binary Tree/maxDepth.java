
#### DFS Solution
# Complexity
- Time complexity: o(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h), h is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));  

    }
}
```

#### BFS Solution
# Complexity
- Time complexity: o(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h), h is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // ans would be the number of levels of a binary tree
        int len=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(root == null) break;

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            len++;
        }

        return root != null ? len : 0;
    }
}
```
