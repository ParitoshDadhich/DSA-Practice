/*
    Approach of this question is, we store all the levels of a perticular level in one stack and add their childeren of every node of perticular level in another stack.
    we keep on traversing until  both stack become empty and while doing so we will get our answer;
*/

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    boolean leftToRight = true;
	    // Each stack represents a perticular level
	    Stack<Node> lrStack = new Stack<>();
	    Stack<Node> rlStack = new Stack<>();
	    ArrayList<Integer> ans = new ArrayList<>();
	    
	    rlStack.push(root);
	    while(!lrStack.isEmpty() || !rlStack.isEmpty()){
	        if(leftToRight){
	            // keep on traversing until rlStack becomes empty
	            // add left then right
	            while(!rlStack.isEmpty()){
	                Node node = rlStack.pop();
	                if(node.left != null) lrStack.push(node.left);
	                if(node.right != null) lrStack.push(node.right);
	                
	                ans.add(node.data);
	            }
	            
	           leftToRight = !leftToRight;
	        }
	        else{
	            // keep on traversing until lrStack becomes empty
	            // add right then left
	            while(!lrStack.isEmpty()){
	                Node node = lrStack.pop();
	                if(node.right != null) rlStack.push(node.right);
	                if(node.left != null) rlStack.push(node.left);
	                
	                ans.add(node.data);
	            }
	            
	           leftToRight = !leftToRight;
	        }
	    }
	    
	    return ans;
	}
}
