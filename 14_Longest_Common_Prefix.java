class Solution {
    public String longestCommonPrefix(String[] strs) {
        String finder = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(finder)!=0){
                finder = finder.substring(0,finder.length()-1);
            }
        }
        return finder;
    }
}

/**
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
