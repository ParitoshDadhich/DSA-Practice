# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
            1. Inorder -> left root right
            2. Postorder -> left right root;
        */
        int len = inorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<len; i++){
            inMap.put(inorder[i], i);
        }

        return buildTree(inorder, 0, len-1, postorder, 0, len-1, inMap);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd, Map<Integer, Integer> inMap){

        if(inStart > inEnd || poStart > poEnd)
            return null;
        
        // root will always be present at the end of postorder array
        int rootValue = postorder[poEnd];
        TreeNode root = new TreeNode(rootValue);
        // fetching the index of root from inorder array map
        int rootIndex = inMap.get(rootValue);
        // number of nodes before root in inorder array
        int numsLeft = rootIndex - inStart - 1;

        root.left = buildTree(inorder, inStart, inStart+numsLeft, postorder, poStart, poStart+numsLeft, inMap);
        root.right = buildTree(inorder, rootIndex+1, inEnd, postorder, poStart+numsLeft+1, poEnd-1, inMap);

        return root;
    }
}
```
