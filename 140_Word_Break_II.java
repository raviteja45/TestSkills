class Solution {
     TrieNode root1 = new TrieNode();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
       for(String word:wordDict){
           insert(word);
       }
        List<List<String>> validLists = new ArrayList<>();
        helper(s, 0, root1, root1, validLists, new ArrayList<>());
        for (List<String> validList : validLists) {
            StringBuilder sb = new StringBuilder();
            sb.append(validList.get(0));
            for (int i = 1; i < validList.size(); i++) {
                sb.append(' ');
                sb.append(validList.get(i));
            }
            result.add(sb.toString());
        }
        return result;
        
    }
    
    private void helper(String s, int curPos, TrieNode root, TrieNode cur, List<List<String>> validLists, List<String> curList) {
        if (cur.word != null) {
            curList.add(cur.word);
            helper(s, curPos, root, root, validLists, curList);
            curList.remove(curList.size() - 1);
        }
        if (curPos == s.length()) {
            if (cur == root) {
                validLists.add(new ArrayList<>(curList));
            }
        } else {
            if (cur.children.containsKey(s.charAt(curPos))) {
                helper(s, curPos + 1, root, cur.children.get(s.charAt(curPos)), validLists, curList);
            }
        }
    }
    public void insert(String s){
        TrieNode temp = root1;
        for(char c:s.toCharArray()){
            Map<Character,TrieNode> child = temp.children;
            if(!child.containsKey(c)){
                child.put(c,new TrieNode());
            }
            temp = child.get(c);
        }
        temp.isPresent = true;
        temp.word = s;
    }
     
}

public class TrieNode{
    public boolean isPresent;
    Map<Character,TrieNode> children;
    String word;
    TrieNode(){
        isPresent  = false;
        children = new HashMap<>();
    }
}


/**
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []

*/
