class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> m =  map.entrySet().
            stream().map(temp->temp.getKey()).collect(Collectors.toList());
	    Collections.sort(m,(w1,w2)->map.get(w2).compareTo(map.get(w1)));
        int h = 0;
        for(int x:m){
            if(h<=k-1){
               res[h] = x;
                h++;
            }
            
        }
        return res;
        
    }
}

/**
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

*/
