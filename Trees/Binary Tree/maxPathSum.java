***Please upvote if you find my solution helpful :)***

# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(h), h is the height of tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution
{
    //Function to return maximum path sum from any node in a tree.
    public int maxPathSum(TreeNode node)
    {
        int sum[] = {Integer.MIN_VALUE};
        helper(node, sum);
        return sum[0];
    }
    
    private int helper(TreeNode node, int[] sum){
        if(node == null){
            return 0;
        }

        int maxLeftPath = helper(node.left, sum);
        int maxRightPath = helper(node.right, sum);
        
        // max path sum considering left subtree and right subtree
        sum[0] = Math.max(sum[0], maxLeftPath + maxRightPath + node.val);

        // max path sum including node and between left subtree & right subtree
        int maxPath = node.val + Math.max(maxLeftPath, maxRightPath) ;

        // we are neglecting all negative path sums
        return maxPath > 0 ? maxPath : 0;
    }
}

```
