// method 1 -> BRUTE FORCE
// Time: O(n2) and Space: o(K), K is the size of the window

class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        ArrayList<Long> list = new ArrayList<>();
        long nonNeg = 0;
        for(int i=0; i<=n-k; i++){
            boolean flag = false;
            for(int j=i; j<i+k; j++){
                if(arr[j] < 0){
                    list.add(arr[j]);
                    flag = true;
                    break;
                }
            }
            if(!flag)
                list.add(nonNeg);
        }
        
        n = list.size();
        long ans[] = new long[n];
        for(int i=0; i<n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}


// method 2 -> SLIDING WINDOW
// Time: O(n) and Space: o(K), K is the size of the window


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        ArrayList<Long> list = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();
        int i=0, j=0;
        long nonNeg = 0;
        
        while(j<n){
            if(arr[j] < 0)
                queue.add(arr[j]);
            
            if(j-i+1 == k){
                if(queue.size() != 0)
                    list.add(queue.peek());
                else
                    list.add(nonNeg);
                
                // if the first element of an array is empty then remove it from the queue, as we slide window 
                if(!queue.isEmpty() && queue.peek() == arr[i])
                    queue.poll();
                
                i++;
            }
            
            j++;
        }
        
        n = list.size();
        long ans[] = new long[n];
        for(i=0; i<n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
