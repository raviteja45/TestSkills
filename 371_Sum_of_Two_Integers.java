class Solution {
    public int getSum(int a, int b) {
       while (b != 0) {
            int carryOver = (a & b) << 1;
            a ^= b; // Now a is the sum without carry over.
            b = carryOver; // b is the carry over now.
        }
        return a;
    }
}

/**
Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
*/
