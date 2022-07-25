class Solution {
    public int longestCommonSubsequence(String text1, String text2) { //Its similar to 516_Longest_Palindromic_Subsequence
        int len1 = text1.length();
        int len2 = text2.length();
        int[][]dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        //To print the string
        int index = dp[len1][len2];
        int temp = index;
        StringBuilder b = new StringBuilder();
        char[] str = new char[index+1];
        int i=len1;
        int j=len2;
        while(i>0&&j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                str[index-1] = text1.charAt(i-1);
                i--;
                j--;
                index--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        for(int k=0;k<temp;k++){
            b.append(String.valueOf(str[k]));
        }
        System.out.println(b);
        //end
        return dp[len1][len2];
    }
}

/**
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/
