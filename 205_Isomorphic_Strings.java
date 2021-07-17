class Solution {
    public boolean isIsomorphic(String s, String t) {
		  Map<Character,Character> m = new HashMap<>();
		  for(int i=0;i<s.length();i++) {
			  if(m.containsKey(s.charAt(i))) {
				  if(m.get(s.charAt(i))!=t.charAt(i)) {
					  return false;
				  }
			  } else if(m.containsValue(t.charAt(i))) {
				  return false;
			  }
			  else {
				  m.put(s.charAt(i), t.charAt(i));
			  }
		  }
		  return true;
    }
}

/**

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true

*/
