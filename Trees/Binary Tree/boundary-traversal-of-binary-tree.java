Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(Height of the Tree).


class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node.left == null && node.right == null){
	        ans.add(node.data);
	        return ans;
	    }
	    
	    ans.add(node.data);
	    
	    leftView(node.left, ans);
	    bottomView(node, ans);
	    rightView(node.right, ans);
	        
	   return ans;
	}
	
	void leftView(Node node, ArrayList<Integer> ans){
	    if(node == null || (node.left == null && node.right == null))
	        return;
	   
	    ans.add(node.data);
	    if(node.left != null){
	        leftView(node.left, ans);
	    }
	    else{
	        leftView(node.right, ans);
	    }
	    
	    return;
	}
	
	
	void bottomView(Node node, ArrayList<Integer> ans){
	    if(node == null) return;
	    
	    if(node.left == null && node.right == null){
	        ans.add(node.data);
	        return;
	    }
	    
	    bottomView(node.left, ans);
	    bottomView(node.right, ans);
	    
	    return;
	}
	
	void rightView(Node node, ArrayList<Integer> ans){
	    if(node == null || (node.left == null && node.right == null))
	        return;
	   
	    if(node.right != null){
	        rightView(node.right, ans);
	    }
	    else{
	        rightView(node.left, ans);
	    }
	    
	    ans.add(node.data);
	    return;
	}
}
