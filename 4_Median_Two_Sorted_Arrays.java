class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length+nums2.length];
        double median = 0.0;
        int m = 0;
        for(int x = 0;x<nums1.length;x++){
            res[x] = nums1[x];
            m++;
        }
        for(int x = m,k = 0;k<nums2.length;x++,k++){
            res[x] = nums2[k];
        }
        Arrays.sort(res);
        int mid = res.length/2;
       
        if(res.length%2==0){
           
            median = (res[mid]+res[mid-1])/2.0;
        }else{
            median = res[mid];
        }
        return median;
    }
}


/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000

*/
