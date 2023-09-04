// method 1
// time:O(n2)
// space: O(h)

public static void changeTree(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return;
        
        // convert left and right subtrees
        changeTree(root.left);
        changeTree(root.right);

        int leftData=0, rightData=0, diff=0;
        if(root.left != null)
            leftData = root.left.val;
        if(root.right != null)
            rightData = root.right.val;
        
        int diff = leftData + rightData - root.val;
        if(diff > 0)
            root.val = leftData + rightData;
        // if diff will be less than 0 then we need to either left subtree or right subtree 
        else if(diff < 0)
            increment(node, -diff);

    }

    void increment(TreeNode node, int diff){
        if(node.left != null){
            node.left.val = node.left.val + diff;
            // call the descendants to fix their values
            increment(node.left, diff);
        }
        else{
            node.right.val += diff;
            increment(node.right, diff);
        }
    }

// method 2
// time: o(n)
// space: o(h)

public static void changeTree(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return;
        
        int child = 0;
        if(root.left != null)
            child += root.left.data;
        if(root.right != null)
            child += root.right.data;
        
        // updating the value of root if children sum is greater than root sum
        // or else updating the value of children nodes to the value of root.data
        if(root.data <= child)
            root.data = child;
        else{
            if(root.left != null)
                root.left.data = root.data;
            if(root.right != null)
                root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.left);

        int tot = 0;
        if(root.left != null)
            tot += root.left.data;
        if(root.right != null)
            tot += root.right.data;
        
        // once recursive calls gets over then update the value of root's data to the sum of their child nodes
        if(root.left != null || root.right != null)
            root.data = tot;

        return;
    }
