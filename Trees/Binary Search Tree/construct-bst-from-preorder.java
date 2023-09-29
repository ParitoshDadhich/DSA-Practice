***Please upvote if you find my solution helpful***


#### INSERT NODES APPROACH

# Complexity
- Time complexity: o(N^2)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(H), H is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length > 1) {
            createBST(root, preorder, 1);
        }

        return root;
    }

    private void createBST(TreeNode root, int[] preorder, int sI) {
        if(sI == preorder.length) {
            return;
        }

        TreeNode node = new TreeNode(preorder[sI]);
        insertNode(root, node);
        createBST(root, preorder, sI+1);
    }

    private void insertNode(TreeNode root, TreeNode node) {
        if(root == null) {
            return;
        }

        if(root.val > node.val) {
            insertNode(root.left, node);
        } else {
            insertNode(root.right, node);
        }

        if(root.left == null && root.val > node.val) {
            root.left = node;
        } else if(root.right == null && root.val < node.val) {
            root.right = node;
        }
    }
}
```
#### USING UPPER BOUND AND LOWER BOUND

# Complexity
- Time complexity: o(N)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(H), H is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

   private TreeNode constructBST(int[] preorder, int minBound, int maxBound) {
        if (index == preorder.length || preorder[index] < minBound || preorder[index] > maxBound) {
            return null;
        }

        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        root.left = constructBST(preorder, minBound, val);
        root.right = constructBST(preorder, val, maxBound);

        return root;
    }

}
```
#### USING UPPER BOUND

# Complexity
- Time complexity: o(N)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(H), H is the height of the tree
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode constructBST(int[] preorder, int maxBound, int[] index){
        if(index[0] == preorder.length || preorder[index[0]] > maxBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = constructBST(preorder, root.val, index);
        root.right = constructBST(preorder, maxBound, index);

        return root;
    }
}
```

#### USING INORDER + PREORDER TO FORM BST

# Approach
- Sort preorder array -> will get sorted array (inorder of BST)
- Use preorder array and inorder array to form BST
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

# Complexity
- Time complexity: o(NlogN)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: o(n), auxilarry array for storing inorder
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

