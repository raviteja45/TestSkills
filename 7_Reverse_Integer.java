class Solution {
    public int reverse(int x) {
        int n = x;
        long res = 0;
        while(n!=0){
            int k = n%10;
            res = (res*10)+k;
            n = n/10;
        }
         if(res>Integer.MAX_VALUE  || res<Integer.MIN_VALUE )
            return 0;
        return (int)res;
    }
}


/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0


*/
