class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1, i = m+n-1;
        while(p2>=0){
            if(p1>=0&&nums1[p1]>=nums2[p2]){// If the last element in nums1 is greater than last element in nums2
                nums1[i] = nums1[p1]; // Assign the nums1 value at ith position.
                i--; // decrement the i value
                p1--; // decrement the nums1 value position
            }else{// If the last element in nums2 is greater than last element in nums1
                nums1[i] = nums2[p2]; 
                i--;
                p2--;
            }
        }
    }
}
//https://www.youtube.com/watch?v=C4oBXLr3zos&ab_channel=AlgorithmsMadeEasy
// 1 2 3 0 0 0 , m is length of non-zero, n is length of nums2 and zeros in nums1
// Here i is total length. We are comparing from last elements of both arrays. 

---------------------------V2------------------------------------------------

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       Queue<Integer> q = new PriorityQueue<>();
       for(int i=0;i<m;i++){
               q.add(nums1[i]);
       }
       for(int i=0;i<n;i++){
           q.add(nums2[i]);
       }
       for(int i=0;i<m+n;i++){
           nums1[i] = q.poll();
       }
    }
}
 
/**
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
*/
