class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;
        while(high-low>=k){ // We need K elements anyways,
            if(Math.abs(arr[low]-x)>Math.abs(arr[high]-x)){//diff(low num - x) is more move to
                                                         // right(low++).else move left(high--)
                low++;
            }else{
                high--;
            } 
        }
        for(int i=low;i<=high;i++){
            res.add(arr[i]);
        }
        return res;
    }
}

/**
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
*/
