class Solution {
    public int longestValidParentheses(String s) {  
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'&&stack.peek()!=-1&&s.charAt(stack.peek())=='('){
                stack.pop();
                 max = Math.max(max,i-stack.peek());
                
            }else{
                stack.push(i);
            }
        }
 		
		return max;
	    
    }
}



/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


*/
