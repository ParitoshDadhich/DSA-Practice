class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<>();
        long[] ans = new long[n];
        int k=n-1;
        
        for(int i=n-1; i>=0; i--) {
            if(st.size() == 0)
                ans[k--] = -1l;
            
            if(st.size() > 0 && arr[i] < st.peek()) {
                ans[k--] = st.peek();
            }
            else if(st.size() > 0 && arr[i] >= st.peek()) {
                while(st.size() > 0 && arr[i] >= st.peek()) {
                    st.pop();
                }
                
                if(st.size() > 0) {
                    ans[k--] = st.peek();
                } else {
                    ans[k--] = -1l;
                }
            }
            
            st.push(arr[i]);
        }
        
        return ans;
    } 
}
