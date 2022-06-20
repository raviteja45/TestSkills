class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int max_count = 0;
        int left = 0;
        int res = 0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            max_count = Math.max(max_count,map.get(s.charAt(right)));
            if(right-left+1-max_count>k){ // Here we are cheking if there are more characters that needs to be replaced than K, 
                                          //if yes, then we have to remove from left (sliding window)
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}


/**
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/
