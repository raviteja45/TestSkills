class Solution {
    public boolean checkInclusion(String s1, String s2) {// Same as Find all anagrams
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int matched = 0;
        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    matched++;
                }
            }
            if(i>=s1.length()){
                c = s2.charAt(i-s1.length());
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)==1){
                        matched--;
                    }
                }
            }
            if(matched==map.size()){
                return true;
            }
        }
        return false;
    }
}

/**
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

*/
