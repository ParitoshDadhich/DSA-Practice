Methods to solve
1. 2 for loops -> n^2

2. Sort the array and then search
    public static int findDuplicate(ArrayList<Integer> arr) {

		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++){
			if(arr.get(i) != i+1){
				return arr.get(i);
			}
		}

		return -1;
	}
  
3. Use HashMAp or HashSet

4. Sum of first Natural (n-1) elemts - array sum

5. XOR approach

static int findRepeating(int arr[], int N)
    {
 
        // res is going to store value of
        // 1 ^ 2 ^ 3 .. ^ (N-1) ^ arr[0] ^
        // arr[1] ^ .... arr[n-1]
        int res = 0;
        for (int i = 0; i < N - 1; i++)
            res = res ^ (i + 1) ^ arr[i];
        res = res ^ arr[N - 1];
 
        return res;
    }
