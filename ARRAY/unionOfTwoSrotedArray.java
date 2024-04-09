import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        int lenA = a.length;
        int lenB = b.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(Integer.MIN_VALUE);

        int i=0, j=0;
        while(i<lenA && j<lenB) {
            if(a[i] < b[j]) {
                if(ans.get(ans.size()-1) != a[i]) {
                    ans.add(a[i]);
                }
                i++;
            } else if(a[i] == b[j] ){
                if(ans.get(ans.size()-1) != b[j]) {
                    ans.add(b[j]);
                 }
                j++;
                i++;
            }
            else {
            if(ans.get(ans.size()-1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
            }
        }

        while(i<lenA) {
            if(ans.get(ans.size()-1) != a[i]) 
                ans.add(a[i]);
            i++;
        }

        while(j<lenB) {
            if(ans.get(ans.size()-1) != b[j]) 
                ans.add(b[j]);
            j++;
        }

        ans.remove(0);
        return ans;
    }
}
