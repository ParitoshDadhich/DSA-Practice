***Please upvote if you like my solution***
# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n), for creating nodes string
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return " ";

        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                str.append("# ");
                continue;
            }
            else
                str.append(node.val + " ");
            
            queue.add(node.left);
            queue.add(node.right);
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == " ")
            return null;

        int index = 0;
        String nodes[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode parentNode = queue.poll();
            if(nodes[index].equals("#"))
                parentNode.left = null;
            else{
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                parentNode.left = leftNode;
                queue.add(leftNode);
            }
            index++;

            if(nodes[index].equals("#"))
                parentNode.right = null;
            else{
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                parentNode.right = rightNode;
                queue.add(rightNode);
            }
            index++;
        }

        return root;
    }
}


```
