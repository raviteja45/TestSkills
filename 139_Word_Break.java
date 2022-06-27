class Solution {
    Trie root = new Trie();
    public boolean wordBreak(String s, List<String> wordDict) {
    for(String word:wordDict){
           insert(word);
       }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++){
            if(!dp[i]){
                continue;
            }
            int j =i;
            Trie curr = root;
            while(j<s.length()&&curr.children.containsKey(s.charAt(j))){
                curr = curr.children.get(s.charAt(j));
                j++;
                if(curr.isPresent){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
        
    }
  public void insert(String word){
        Trie temp = root;
        for(char c:word.toCharArray()){
            Map<Character,Trie> map = temp.children;
            if(!map.containsKey(c)){
                map.put(c,new Trie());
            }
            temp = map.get(c);
        }
        temp.isPresent = true;
    }
    
     public class Trie{
         public boolean isPresent;
         public Map<Character,Trie> children;
         Trie(){
             isPresent = false;
             children = new HashMap<>();
         }
     }
}


/**
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

*/
