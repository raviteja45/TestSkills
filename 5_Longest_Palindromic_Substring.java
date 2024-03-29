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

//V2

class Solution {
    public String longestPalindrome(String str) {
        String res = null;
        for(int i=0;i<str.length();i++){
            res = findPalindrome(i,i,str,res);
            res = findPalindrome(i,i+1,str,res);
        }
        return res;
    }
    public String findPalindrome(int low,int high,String str,String res){
        while(low>=0&&high<str.length()&&str.charAt(low)==str.charAt(high)){
            low--;
            high++;
        }
        String temp = str.substring(low+1,high);
        if(res==null)
            return temp;
        else
            return temp.length()>res.length()?temp:res;
    }
}

//V3

class Solution {
    public String longestPalindrome(String s) {
        String x="";
       for(int i=0;i<s.length();i++){
           x = findPalindrome(s,i,i,x); // scenario for 'racecar' where middle element is single
           x = findPalindrome(s,i,i+1,x);//scenario for 'aaabbaaa' where there is no single middle element
       }
        return x;
    }
    public String findPalindrome(String s,int left,int right,String max){
        
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(right-(left+1)>max.length()){
            max = s.substring(left+1,right);
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
