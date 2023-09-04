//Expected Time Complexity: O(N).
//Expected Auxiliary Space: O(N).


class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        if(root == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(root.data);
        ans.addAll(preorder(root.left));
        ans.addAll(preorder(root.right));
        
        return ans;
            
    }

}
