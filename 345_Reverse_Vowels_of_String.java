class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j = s.length()-1;
        String vow = "aeiouAEIOU";
        char[] res = s.toCharArray();
        while(i<j){
            while(i<j&&vow.indexOf(s.charAt(i))==-1){
                i++;
            }
            while(i<j&&vow.indexOf(s.charAt(j))==-1){
                j--;
            }
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
        return new String(res);
    }
}

/**
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
*/
