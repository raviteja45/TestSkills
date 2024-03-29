class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0;i<=num;i++){
            int res1 = 0;
            String x = Integer.toBinaryString(i);
            char[] m = x.toCharArray();
            for(char c:m){
                if(c=='1'){
                    res1 = res1+1;
                }
            }
            res[i] = res1;
        }
        return res;
    }
}


/**
Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].

 

Example 1:

Input: num = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: num = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= num <= 105
 

Follow up:

It is very easy to come up with a solution with run time O(32n). Can you do it in linear time O(n) and possibly in a single pass?
Could you solve it in O(n) space complexity?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

*/
