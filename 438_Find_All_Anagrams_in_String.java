class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] tes = p.toCharArray();
        Arrays.sort(tes);
        for(int i=0;i<s.length();i++){
            if(i+p.length()<=s.length()){
              char[] l = (s.substring(i,i+p.length())).toCharArray();
            Arrays.sort(l);
            if(new String(tes).equals(new String(l))){
                res.add(i);
            }  
            }
            
        }
        return res;
    }
}


/**
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

*/
