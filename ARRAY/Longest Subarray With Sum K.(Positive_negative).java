import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int len = nums.length;
		int sum = 0, ans=0;
		for(int i=0; i<len; i++) {
			sum += nums[i];

			if(map.containsKey(sum-k)){
				ans = Math.max(ans, i-map.get(sum-k));
			}

			if(!map.containsKey(sum)){
				map.put(sum, i);
			}
		}
		return ans;
	}
}
