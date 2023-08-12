// method 1 -> BRUTE FORCE
// time : O(n^2)
// space : O(n)

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int max = -1;
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                char ch = s.charAt(j);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                }
                else{
                    map.put(ch, 1);
                }
                
                if(map.size() == k){
                    max = Math.max(max, j-i+1);
                }
                else if(map.size() > k){
                    break;
                }
            }
            map.clear();
        }
        
        return max;
    }
}


// method 2 -> SLIDING WINDOW
// time : O(n)
// space : O(n)

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int max=-1, i=0, j=0;
        while(j<len){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            if(map.size() < k){
                j++;
            }
            else if(map.size() == k){
                max = Math.max(max, j-i+1);
                j++;
            }
            else if(map.size() > k){
              // will be keep on incrementing i untill map.size() will be equal or less than k
              // if the occurence of any character becomes zero then remove it from the map
                while(map.size() > k){
                    char c = s.charAt(i);
                    if(map.containsKey(c)){
                        map.put(c, map.get(c)-1);
                        if(map.get(c) == 0){
                            map.remove(c);
                        }
                    }
                    i++;
                }
                j++;
            }
            
        }
        
        return max;
    }
}
