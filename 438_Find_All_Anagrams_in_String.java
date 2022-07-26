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

-----------------------------v2 -------------------------------
    
class Solution {
    public List<Integer> findAnagrams(String s, String p) { //76. Minimum Window Substring
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<p.length();i++){
          map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);  
        }
        int matched = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    matched++;
                }
            }
            if(i>=p.length()){
               char c1 = s.charAt(i-p.length());
                if(map.containsKey(c1)){
                    map.put(c1,map.get(c1)+1);
                    if(map.get(c1)==1){
                        matched--;
                    }
                }
            }
            if(matched==map.size()){
                res.add(i-p.length()+1);
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
