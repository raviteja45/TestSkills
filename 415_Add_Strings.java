class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0||carry==1){
            int n1 = 0;
            int n2 = 0;
            if(i>=0){
                n1 = num1.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                n2 = num2.charAt(j)-'0';
                j--;
            }
            int tot = n1+n2+carry;
            sb.append(tot%10);
            if(tot>=10){
                carry = 1;
            }else{
                carry = 0;
            }
        }
        return sb.reverse().toString();
    }
}

/**
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"

*/
