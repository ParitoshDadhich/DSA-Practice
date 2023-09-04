// Time: o(n)
// space: o(n)

class Solution
{
    
    static ArrayList<Integer> topView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node node = pair.node;
            int level = pair.level;
            
            // adding the very first element of a perticular level only
            if(!map.containsKey(level))
                map.put(level, node.data);
            
            if(node.left != null)
                queue.add(new Pair(node.left, level-1));
            if(node.right != null)
                queue.add(new Pair(node.right, level+1));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val: map.keySet()){
            ans.add(map.get(val));
        }
        
        return ans;
    }
}

class Pair{
    Node node;
    int level;
    
    Pair(Node _node, int _level){
        node = _node;
        level = _level;
    }
}
