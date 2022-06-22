class Solution {

    int[] original;
    int[] temp;
    public Solution(int[] nums) {
        original = nums.clone();
        temp = nums.clone();
    }
    
    public int[] reset() {
        return temp;
    }
    
    public int[] shuffle() {
      
      /**  Random r = new Random();
        int x = 0;
        int y = 0;
        while(x!=y)
        {
            x = r.nextInt(original.length);
            y = r.nextInt(original.length);
        }
        
        int k = original[x];
        original[y] = original[x];
        original[x] = k;
        return original;*/
      // Above also works, but failing some test cases.
        Random random = new Random();
        for(int j = 1; j < original.length; j++) {
            int i = random.nextInt(j + 1);
            swap(original, i, j);
        }
        return original;
    }
    
     private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

/**
Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.
 

Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

*/
