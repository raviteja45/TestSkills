class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracking(s,0,new ArrayList<>(),result);
        return result;
    }
    
    public void backTracking(String s, int start, List<String> temp, List<List<String>> res){
        if(s.length()==start){
            res.add(new ArrayList<>(temp));
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backTracking(s,i+1,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}


/**
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]

*/
