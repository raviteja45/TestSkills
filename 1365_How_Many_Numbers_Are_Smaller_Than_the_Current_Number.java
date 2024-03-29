class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cloned = new int[nums.length];
        int[] res = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            cloned[i] = nums[i];
        }
        Arrays.sort(cloned);
        for(int k=0;k<cloned.length;k++){
            if(!map.containsKey(cloned[k])){
                map.put(cloned[k],k);
            }
        }
        for(int d = 0;d<nums.length;d++){
            res[d] = map.get(nums[d]);
        }
        return res;
    }
}


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        for(int i=0;i<temp.length;i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i],i);
            }
        }
        for(int i=0;i<nums.length;i++){
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}

/**
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
*/
