//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; i++) {
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int possible_paths(int[][] edges, int n, int start, int destination) {
        if(start == destination) return 1;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        // for(int[] edge: edges){
        //     adj.get(edge[0]).add(edges[1]);
        // }
        
        
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        currentPath.add(start);
        dfs(adj, start, destination, allPaths, currentPath);
        
        // print all paths
        // for(ArrayList<Integer> list: allPaths){
        //     System.out.println(list);
        // }
        
        return allPaths.size();
        
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int start, int destination, ArrayList<ArrayList<Integer>> allPaths, ArrayList<Integer> currentPath){
        
        
        if(start == destination){
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        
        // traverse adjNodes
        for(Integer adjNode: adj.get(start)){
            currentPath.add(adjNode);
            dfs(adj, adjNode, destination, allPaths, currentPath);
            currentPath.remove(adjNode); // backtrack
            
        }
    }
    
    private void bfs(ArrayList<ArrayList<Integer>> adj, int start, int destination, ArrayList<ArrayList<Integer>> allPaths, ArrayList<Integer> currentPath){
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(currentPath);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> path = queue.poll();
            
            int currentNode = path.get(path.size()-1);
            
            if(currentNode == destination){
                allPaths.add(new ArrayList<>(path));
                continue;
            }
            
            for(Integer adjNode: adj.get(currentNode)){
                ArrayList<Integer> newPath = new ArrayList<>(path);
                newPath.add(adjNode);
                queue.add(newPath);
            }
        }
        
    }
}
