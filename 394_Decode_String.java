class Solution {
    public String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        StringBuilder builder = new StringBuilder();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                StringBuilder b = new StringBuilder();
                while(Character.isDigit(s.charAt(i))){
                    b.append(String.valueOf(s.charAt(i)));
                    i++;
                }
                number.push(Integer.valueOf(String.valueOf(b)));
            }
            if(Character.isAlphabetic(s.charAt(i))){
                builder.append(s.charAt(i));
            }
            if(s.charAt(i)=='['){
                strStack.push(builder);
                builder = new StringBuilder();
            }
            if(s.charAt(i)==']'){
                StringBuilder m = strStack.pop();
                int k = number.pop();
                StringBuilder x = new StringBuilder(m);
                for(int u=0;u<k;u++){
                    x.append(builder);
                }
                builder = x;
            }
        }
        return builder.toString();
    }
}


/**
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

*/
