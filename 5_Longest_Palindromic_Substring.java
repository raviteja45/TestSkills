class Solution {
    public String longestPalindrome(String str) {
        List<String> res = new ArrayList<>();
        String max="";
		  for(int i=0;i<str.length();i++){
             max =  findPalindrome(i,i,res,str,max);
              max = findPalindrome(i,i+1,res,str,max);
          }
        return max;
	 }
    
    public String findPalindrome(int low, int high, List<String> res,String str , String max){
        while(low>=0&&high<str.length()&&
              str.charAt(low)==str.charAt(high)){
            low--;
            high++;
        }
       res.add(str.substring(low+1,high));
       int len = max.length();
       int len1 = high-(low+1);
    if(len<len1){
                max = str.substring(low+1,high);
            }
        
      return max;
    }
}

/**
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"

*/
