class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int k = 0;
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])&&map.get(nums2[i])>0){
                res.add(nums2[i]);
                k++;
                map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
            }
            
        }
        int[] o = new int[res.size()];
        int m = 0;
        for(int j:res){
            o[m] = j;
            m++;
        }
       
        return o;
    }
}

/**
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

*/
