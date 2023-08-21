// Iterative solution
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int sI=0, eI=len-1;

        while(sI <= eI){
            int mid = sI + (eI-sI)/2;
            char ch = letters[mid];

            if(ch > target){
                eI = mid-1;
            }
            // moving forward because we need next greater element
            else if(ch <= target){
                sI = mid+1;
            }
        }

        return letters[sI%len];

        return helper(letters, target, 0, letters.length-1);
    }
}


// Recursive solution
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return helper(letters, target, 0, letters.length-1);
    }

    public char helper(char[] letters, char target, int sI, int eI){
        if(sI > eI)
            return letters[sI%letters.length];
        
        int mid = sI + (eI-sI)/2;
        char ch = letters[mid];

        if(ch > target)
            eI = mid-1;
        else
            sI = mid+1;
        
        return helper(letters, target, sI, eI);
        
    }
}
