class Solution {
    public int countSubstrings(String s) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
           res =  subStr(i,i,s,res);
           res =  subStr(i,i+1,s,res);
        }
        return res.size();
    }
    
    public List<String> subStr(int low, int high, String s, List<String> res){
        while(low>=0&&high<s.length()&&low<=high&&s.charAt(low)==s.charAt(high)){
            res.add(s.substring(low,high+1));
            low--;
            high++;
        }
        return res;
    }
}


/**
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/
