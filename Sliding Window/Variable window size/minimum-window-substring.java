// method 1 -> brute force : generating all substrings and then comparing characters with the given pattern
// time: O(n)
// space: O(n), for creating substrings

class Solution {
    public String minWindow(String s, String t) {
        int len = s.length();
        String ans = "";
        int minLength = Integer.MAX_VALUE;

        // generate all substrings
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                String subStr = s.substring(i, j+1);

                // checking if the substr contains all the characters
                if(containsAllCharacter(subStr, t)){
                    int subLength = subStr.length();
                    if(minLength > subLength){
                        minLength = subLength;
                        ans = subStr;
                    }
                }
            }
        }

        return ans;
    }

    boolean containsAllCharacter(String str, String pat){
        int count[] = new int[256];
        Arrays.fill(count, 0);

        int patLength = pat.length();
        for(int i=0; i<patLength; i++){
            count[(int)pat.charAt(i)]++;
        }

        // checking for characters in str
        int strLength = str.length();
        for(int i=0; i<strLength; i++){
            count[(int)str.charAt(i)]--;
        }

        for(int i=0; i<256; i++){
            if(count[i] > 0)
                return false;
        }

        return true;
    }
}


// method 2 -> sliding windw
// time: O(n)
// space: O(n)

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int count = map.size();

        int i=0, j=0, len=s.length();
        int start=0, end=0;
        int minAnsLength = Integer.MAX_VALUE;
        while(j < len){
            char ch = s.charAt(j);
            // storing the occurence of every character in map
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }

            if(count == 0){
                // decreasing the size of the window until we increment the size of count
                while(count == 0){
                    char c = s.charAt(i);
                    if(map.containsKey(c)){
                        map.put(c, map.get(c)+1);
                        if(map.get(c) > 0){
                            count++;
                        }
                    }
                    i++;
                }
                // fetching the min length substring
                if(minAnsLength > j-i+1){
                    minAnsLength = j-i+1;
                    start = i-1;
                    end = j+1;
                }
            }
            // moving forward -> increasing the size of window
            j++;
        }

        return s.substring(start, end);
    }
}
