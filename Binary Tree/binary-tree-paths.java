***please upvote if you like the solution :)***

# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(h), h is the height of the binary tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }

    private void helper(TreeNode root, List<String> ans, String path){
        if(root == null)    return;

        if(root.left == null && root.right == null){
            path = path + root.val;
            ans.add(path);
            return;
        }
        else
            path = path + root.val + "->";
        
        helper(root.left, ans, path);
        helper(root.right, ans, path);
    }
}
```
