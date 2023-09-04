//Expected Time Complexity: O(N).
//Expected Auxiliary Space: O(N).

/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       if(root == null)
            return new ArrayList<Integer>();
        
       ArrayList<Integer> ans = new ArrayList<>();
       
       ans.addAll(postOrder(root.left));
       ans.addAll(postOrder(root.right));
       ans.add(root.data);
       
       return ans;
    }
}
