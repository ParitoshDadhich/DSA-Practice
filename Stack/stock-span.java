// method 1
// time o(n^2)

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // STOCK SPAN is same as nearest greater to left question
        int ans[] = new int[n];
    
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=i; j>=0; j--) {
                if(price[j] > price[i]){
                    break;
                } else {
                    count++;
                }
            }
            ans[i] = count;
        }
        
        return ans;
    }
    
}


class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // STOCK SPAN is same as nearest greater to left question
        int ans[] = new int[n];
    
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=i; j>=0; j--) {
                if(price[j] > price[i]){
                    break;
                } else {
                    count++;
                }
            }
            ans[i] = count;
        }
        
        return ans;
    }
    
}



// method 2
// time o(n)
// space o(n)

