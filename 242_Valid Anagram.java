class Solution {
    public boolean isAnagram(String word, String twoWord) {
        

		char[] first = word.toCharArray();
        char[] second = twoWord.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first,second);
		
	
    }
}

/**

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

*/
