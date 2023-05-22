/*
	Time Complexity: O(N)
	Space Complexity: O(N)

	Where 'N' is the total number of elements in the array.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {

		// Declaring a hashmap.
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr.get(i))) {
				map.put(arr.get(i), map.get(arr.get(i)) + 1);
			} else {
				map.put(arr.get(i), 1);
			}

		}
		ArrayList<Pair<Integer, Integer>> ans = new ArrayList<>();

		// Looping over all elements in the array.
		for (int i = 0; i < n; i++) {
			if (target - arr.get(i) == arr.get(i)) {
				if (map.get(arr.get(i)) > 1) {
					ans.add(new Pair(arr.get(i), arr.get(i)));
					map.put(arr.get(i), map.get(arr.get(i)) - 2);
				}
			} else {
				if (map.containsKey(target - arr.get(i)) && map.get(arr.get(i)) > 0
						&& map.get(target - arr.get(i)) > 0) {
							
					ans.add(new Pair(arr.get(i), target - arr.get(i)));
					map.put(arr.get(i), map.get(arr.get(i)) - 1);
					map.put(target - arr.get(i), map.get(target - arr.get(i)) - 1);
				}
			}
		}

		if (ans.size() == 0)
			ans.add(new Pair(-1, -1));

		return ans;
	}
}
