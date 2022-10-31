class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Pair> stackP = new Stack<>();
        char sign = '+';
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    num = num*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                calc(stack,sign,num);
            }else if(s.charAt(i)=='('){
                stackP.push(new Pair(stack,sign));
                sign = '+';
                stack = new Stack<>();
            }else if(s.charAt(i)==')'){
                int num = 0;
                while(!stack.isEmpty()){
                    num = num+stack.pop();
                }
                Pair p1 = stackP.pop();
                stack = p1.stack;
                sign = p1.sign;
                calc(stack,sign,num);
            }
            
            
            else if(s.charAt(i)!=' '){
                sign = s.charAt(i);
            }
        }
        while(!stack.isEmpty()){
            res = res+stack.pop();
        }
        return res;
    }
    
    public void calc(Stack<Integer> stack, char sign, int num){
         if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    int temp = stack.pop();
                    temp = temp*num;
                    stack.push(temp);
                }else if(sign=='/'){
                    int temp = stack.pop();
                    temp = temp/num;
                    stack.push(temp);
                }
    }
}

class Pair{
    Stack<Integer> stack;
    char sign;
    Pair(Stack<Integer> stack, char sign){
        this.stack = stack;
        this.sign = sign;
    }
}

/**
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

*/
