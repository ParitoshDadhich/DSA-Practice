
#### Recursive Solution (Preorder) -> (DFS)

# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrder(root, 0);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root, int level) {
        if(root == null)
            return ans;
        
        if(ans.size() == level)
            ans.add(new ArrayList<>());
        
        ans.get(level).add(root.val);
        levelOrder(root.left, level+1);
        levelOrder(root.right, level+1);

        return ans;
    }
}
```
