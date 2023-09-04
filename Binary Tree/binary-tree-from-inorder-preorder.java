# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // creating this map for accessing root of binary tree or sub trees
        Map<Integer, Integer> inMap = new HashMap<>();
        int len = inorder.length;
        for(int i=0; i<len; i++){
            inMap.put(inorder[i], i);
        }        

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){

        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        // finding the root value
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // finding the index of root from inMap -> inorder map
        // the advantage of crating map is we can retrieve index in o(1) time
        // if we would not have used map then we need to traverse in inorder array in o(n) time
        // by using map we are saving time from o(n) -> o(1)
        int inRoot = inMap.get(rootValue);

        // number of elements that before root in inorder array
        int numsLeft = inRoot-inStart;

        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inStart+inRoot-1, inMap);
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);

        return root;
    } 
}
```
