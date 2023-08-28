/*
    Approach of this question is, we store all the levels of a perticular level in one stack and add their childeren of every node of perticular level in another stack.
    we keep on traversing until  both stack become empty and while doing so we will get our answer;
*/

***Please upvote if you find my solution helpful :)***

# Complexity -> Solution using 2 Stacks
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        boolean leftToRight = true;
        // Here each stack represents a respective level
        Stack<TreeNode> lrStack = new Stack<>();
        Stack<TreeNode> rlStack = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();

        rlStack.push(root);
        while(!rlStack.isEmpty() || !lrStack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(leftToRight){
                // adding left to right
                while(!rlStack.isEmpty()){
                    TreeNode node = rlStack.pop();
                    if(node == null) break;

                    if(node.left != null) lrStack.push(node.left);
                    if(node.right != null) lrStack.push(node.right);

                    list.add(node.val);
                }
            }
            else{
                // adding right to left
                 while(!lrStack.isEmpty()){
                    TreeNode node = lrStack.pop();
                    if(node == null) break;;

                    if(node.right != null) rlStack.push(node.right);
                    if(node.left != null) rlStack.push(node.left);

                    list.add(node.val);
                }
            }
            
            leftToRight = !leftToRight;
            ans.add(list);
        }

        return ans;
    }
}
```
# Complexity -> Solution using a Queue
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    boolean leftToRight = true;
    
    if(root == null)
        return ans;
    
    queue.offer(root);
    while(!queue.isEmpty()){
        int len = queue.size();
        Integer arr[] = new Integer[len];
        // traversing a perticular level
        for(int i=0; i<len; i++){
            TreeNode node = queue.poll();
        
            // finding index to insert into the list;
            // if index -> i, then inserting from front
            // if index -> size-1-i then inserting from back
            int index = leftToRight ? i : (len - 1 - i);
             
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
            
            arr[index] = node.val;
        }
        
        leftToRight = !leftToRight;
        List<Integer> list = Arrays.asList(arr);
        ans.add(list);
        
    }
    
    return ans;
}
}
```
