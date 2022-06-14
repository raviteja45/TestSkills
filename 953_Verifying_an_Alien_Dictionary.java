class Solution {
    Map<Character,Integer> map = null;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            if(!compare(words[i],words[i+1])){
                return false;
            }
        }
        return true;
    }
    
    public boolean compare(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int len = len1>len2?len2:len1;
        int i = 0;
        while(len!=0){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if(c1!=c2){
                if(map.get(c1)<map.get(c2)){
                return true;
            }else{
                    return false;
                }
            }else{
                i++;
                len--;
            }
        }
        if(len1>len2){
            return false;
        }
        
        return true;
    }
}


/**
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info)

*/
