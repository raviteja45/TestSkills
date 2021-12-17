class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backTracking(result,s.toCharArray(),0);
        return result;
    }
    public void backTracking(List<String> result, char[] s, int index){
        if(index==s.length){
            result.add(new String(s));
        }else{
            if(Character.isAlphabetic(s[index])){
            s[index] = Character.toUpperCase(s[index]);
            backTracking(result,s,index+1);
            s[index] = Character.toLowerCase(s[index]);
        }
            backTracking(result,s,index+1);
        }
        
    }
}


/**
Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: s = "12345"
Output: ["12345"]
Example 4:

Input: s = "0"
Output: ["0"]

*/
