class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();
        int x = nums.length/3;
        for(int i=0;i<nums.length;i++){
            if(x==0){
                //result.add(nums[i]);
                temp.add(nums[i]);
            }else if(x>0){
                m.put(nums[i],m.getOrDefault(nums[i],0)+1);
                if(m.get(nums[i])>x){
                    //result.add(nums[i]);
                    temp.add(nums[i]);
                }
            }
            
        }
        result.addAll(temp);
        return result;
    }
}

/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

*/
