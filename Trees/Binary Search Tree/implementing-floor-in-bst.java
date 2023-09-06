// RECURSIVE

class Solution {
    static int ans = -1;
    public static int floor(Node root, int x) {
        if(root == null)
            return ans;
        
        if(root.data == x){
            ans = root.data;
            return ans;
        }
        
        if(root.data > x)
            return floor(root.left, x);
        else{
            ans = root.data;
            return floor(root.right, x);
        }
    }
}

// ITERATIVE
class Solution {
    public static int floor(Node root, int x) {
        if(root == null) return -1;
        
        int ans = -1;
        while(root != null){
            
            if(root.data == x)
                ans = root.data;
            
            if(root.data > x)
                root = root.left;
            else{
                ans = root.data;
                root = root.right;
            }
        }
        
        return ans;
    }
}
