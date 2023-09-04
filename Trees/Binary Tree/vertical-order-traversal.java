
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    public Tuple(TreeNode _node, int _vertical, int _level){
        node = _node;
        vertical = _vertical;
        level = _level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if(!map.containsKey(vertical))
                map.put(vertical, new TreeMap<>());
            if(!map.get(vertical).containsKey(level))
                map.get(vertical).put(level, new PriorityQueue<>());

            map.get(vertical).get(level).offer(node.val);

            if(node.left != null){
                queue.offer(new Tuple(node.left, vertical-1, level+1));
            }
            if(node.right != null){
                queue.offer(new Tuple(node.right, vertical+1, level+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> levelIter: map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodes: levelIter.values()){
                while(!nodes.isEmpty()){
                    // System.out.println(nodes.peek());
                    list.add(nodes.poll());
                }
            }
            ans.add(list);
        }

        return ans;
    }
}

// DFS -> solution

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        map = new TreeMap<>();
        helper(root, 0, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(Map<Integer, PriorityQueue<Integer>> levelItr: map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodes: levelItr.values()){
                while(!nodes.isEmpty())
                    list.add(nodes.poll());
            }
            ans.add(list);
        }
        
        return ans;
    }
    
    void helper(TreeNode root, int ver, int lev){
        if(root == null)
            return;
        
        if(!map.containsKey(ver))
            map.put(ver, new TreeMap<>());
        if(!map.get(ver).containsKey(lev))
            map.get(ver).put(lev, new PriorityQueue<>());
        
        map.get(ver).get(lev).add(root.val);
        
        helper(root.left, ver-1, lev+1);
        helper(root.right, ver+1, lev+1);
        
        return;
    }
}
