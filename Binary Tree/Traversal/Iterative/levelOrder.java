***Please upvote, if you find my solution helpful!***

#### Iterative Solution (BFS)

# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        // here null "null" signifies the ending of a perticular level
        nodes.add(root);
        nodes.add(null);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            // traverse all elements onto a perticular level
            for(int i=0; i<size; i++){
                TreeNode node = nodes.poll();
                if(node == null) break;

                if(node.left != null)
                    nodes.add(node.left);
                if(node.right != null)
                    nodes.add(node.right);

                // adding node into list;
                list.add(node.val);
            }
            ans.add(list);
            if(!nodes.isEmpty())
                nodes.add(null);
        }

        return ans;
    }
}
```
