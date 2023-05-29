// METHOD 1
// TIME O(N)
// SPACE O(N)

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            ans[arr[i]]++;
        }
        
        for(int i=0; i<n; i++){
            if(ans[i] > 1)
                temp.add(i);
        }
        
        if(temp.size() == 0)
            temp.add(-1);
            
        return temp;
    }
}


// method 2 (solve)

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int zeroCount = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                zeroCount++;
                continue;
            }
            int t = arr[i]%n;
            arr[t] = arr[t] + n;
        }
        
        // for(int i: arr)
        //     System.out.print(i + " ");
        
        
         System.out.print(zeroCount + " ");
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(arr[i] == 0 && (zeroCount > 1) && flag){
                ans.add(arr[i]);
                flag = false;
            }
            else if(arr[i] >= 2*n){
                ans.add(i);
            }
        }
        
        if(ans.size() == 0)
            ans.add(-1);
            
        return ans;
    }
}
