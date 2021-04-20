class Solution {
    public void reverseString(char[] s) {
        int k = s.length-1;
        for(int i=0;i<s.length;i++){
            if(i<s.length/2){
                char c = s[i];
            s[i] = s[k];
            s[k] = c;
            k--;
            }
            
        }
    }
}


/**
Write a function that reverses a string. The input string is given as an array of characters s.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

*/
