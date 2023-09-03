// time: O(n)
// space: O(n)

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // Creating a map for storing child and its corresponding parent
        Map<Node, Node> child_parent = new HashMap<>();
        markParents(root, child_parent);
        
        // first I need to search for the target node;
        Node targetNode = findTargetNode(root, target);
        
        if(targetNode == null)
            return new ArrayList<>();
        
        // At this position
        // I have targetNode and child-parent map;
        // I will take help of child-parent map and move upward, leftward and rightward from the targetNode;
        // STEPS:
        /*
            For achieveing this ->
                I will use queue
                I will use visited map -> for marking whether the node is visited or not
        */
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.add(targetNode);
        visited.put(targetNode, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                
                // checkin left node is visisted or not
                if(node.left != null && visited.get(node.left) == null){
                    queue.add(node.left);
                    visited.put(node.left, true);
                }
                // checking right node is visited or not
                if(node.right != null && visited.get(node.right) == null){
                    queue.add(node.right);
                    visited.put(node.right, true);
                }
                // checking node's parent is visited or not
                Node parentNode = child_parent.get(node);
                if(parentNode != null && visited.get(parentNode) == null){
                    queue.add(parentNode);
                    visited.put(parentNode, true);
                }
            }
        }
        
        // Now all the nodes in queue are at distance k from targetNode;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().data);
        }
        
        Collections.sort(ans);
        return ans;
    }
    
    private static Node findTargetNode(Node root, int target){
        if(root == null)
            return null;
        
        if(root.data == target)
            return root;
        
        Node leftTarget = findTargetNode(root.left, target);
        if(leftTarget != null)
            return leftTarget;
        
        return findTargetNode(root.right, target);
    }
    
    private static void markParents(Node root, Map<Node, Node> child_parent){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // crating child-parent relationship using level order traversal
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                
                if(node.left != null){
                    child_parent.put(node.left, node);
                    queue.add(node.left);
                }
                if(node.right != null){
                    child_parent.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }
        
        // System.out.println("Child parent relationship");
        // for(Node node: child_parent.keySet()){
        //     System.out.println(node.data + " " + child_parent.get(node).data);
        // }
    }
};
