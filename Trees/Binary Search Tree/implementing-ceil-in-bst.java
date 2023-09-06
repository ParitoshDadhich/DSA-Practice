// ITERATIVE
// time o(logn)
// space o(1)

class Tree {
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        int ans = -1;
        while(root != null){
            
            if(root.data == key)
                return key;
            
            if(root.data > key){
                ans = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        
        return ans;
    }
}


// RECURSIVE
// time o(logn)
// space o(logn)

class Tree {
    // Function to return the ceil of given number in BST.
    int ans = -1;
    int findCeil(Node root, int key) {
        if (root == null) return ans;
        
        if(key == root.data){
            ans = key;
            return ans;
        }
        
        if(key < root.data){
            ans = root.data;
            return findCeil(root.left, key);
        }
        else{
            return findCeil(root.right, key);
        }
        
    }
}
