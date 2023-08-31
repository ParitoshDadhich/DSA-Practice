// time: o(n)
// space: o(n)

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = true;
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                if(node == null) continue;
                if(flag){
                    list.add(node.data);
                    flag = false;
                }
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        
        return list;
    }
}
