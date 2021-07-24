class Solution {
    public boolean isPalindrome(String s) {
        String x = s.toLowerCase();
        StringBuilder m = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))&&s.charAt(i)!=' '){
                m.append(String.valueOf(x.charAt(i)));
            }
        }
        for(int i=0;i<m.length()/2;i++){
            if(m.charAt(i)!=m.charAt(m.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}


/**

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

*/
