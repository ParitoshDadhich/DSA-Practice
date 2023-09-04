// time: o(n)
// space: o(n)

class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node node = pair.node;
            int level = pair.level;
            
            map.put(level, node.data);
            
            if(node.left != null)
                queue.add(new Pair(node.left, level-1));
            if(node.right != null)
                queue.add(new Pair(node.right, level+1));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int node: map.keySet())
            ans.add(map.get(node));
        
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
