// method 1 -> brute force
// time: O(n2)
// space: O(n)

class Solution{
    int longestUniqueSubsttr(String s){
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int max=0, i=0, j=0;
        
        for(i=0; i<len; i++){
            for(j=i; j<len; j++){
                char ch = s.charAt(j);
                if(!set.contains(ch)){
                    set.add(ch);
                }
                else{
                    break;
                }
            }
            max = Math.max(set.size(), max);
            set.clear();
        }
        return max;
    }
}

// method 2 -> sliding window using hashset
// time: o(n)
// space: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;

        Set<Character> set = new HashSet<>();
        int i=0, j=0, max=0;
        while(j < len){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                max = Math.max(max, j-i+1);
                j++;
            }
            else{
                // will keep on remeoving elemetns starting from i untill we remove ch from the set
                while(set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }

        return max;
    }
}


// method 3 -> sliding window using hashmap
// time: O(n)
// space: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, max=0;
        while(j < len){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) == 1){
                max = Math.max(max, j-i+1);
                j++;
            }
            else if(map.get(ch) > 1){
                while(map.containsKey(ch)){
                    map.remove(s.charAt(i));
                    i++;
                }
                map.put(ch, 1);
                j++;
            }
        }

        return max;
    }
}
