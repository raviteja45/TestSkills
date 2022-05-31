class Solution {
    public boolean backspaceCompare(String s, String t) {
        return compute(s).equals(compute(t));
    }
    
    public Stack<Character> compute(String s){
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c!='#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                
                stack.pop();
            }
        }
        return stack;
    }
}


/**
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

*/
