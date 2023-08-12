// method 1 -> BRUTE FORCE
// time : o(nKlogk), k is the size of the key/txt, space: O(1)

class Solution {

    int search(String pat, String txt) {
        int k = txt.length();
        int n = pat.length();
        
        char[] txtArray = txt.toCharArray();
        Arrays.sort(txtArray);
        int count = 0;
        
        for(int i=0; i<=n-k; i++){
            String patSubstring = pat.substring(i, i+k);
            char[] patArray = patSubstring.toCharArray();
            Arrays.sort(patArray);
            if(Arrays.equals(patArray, txtArray))
                count++;
        }
        
        return count;
    }
}

// method 2 -> sliding window
// time: O(n)
// space: O(256) or O(26)

class Solution {

     int search(String pat, String str) {
        int k = pat.length();
        int n = str.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++){
            char ch = pat.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        
        int distinctElement = map.size();
        int i=0, j=0, count=0;
        
        while(j<n){
            char ch = str.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0)
                    distinctElement--;
            }
            
            if(j-i+1 == k){
                if(distinctElement == 0)
                    count++;
                    
                char ele = str.charAt(i);
                if(map.containsKey(ele)){
                    map.put(ele, map.get(ele)+1);
                    if(map.get(ele) == 1){
                        distinctElement++;
                    }
                }
                i++;
            }
            
            j++;
        }
        
        return pat.equals(" ") == true ? n : count;
    }
}
