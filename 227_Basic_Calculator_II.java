public class Solution {
public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
        if(Character.isDigit(s.charAt(i))){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
            if(sign=='-'){
                stack.push(-num);
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);
            }
            if(sign=='/'){
                stack.push(stack.pop()/num);
            }
            sign = s.charAt(i);
            num = 0;
        }
    }

    int re = 0;
    for(int i:stack){
        re += i;
    }
    return re;
}
}

-----------------------------V2------------------------------------------
    
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    num = 10*num+(s.charAt(i)-'0');
                    i++;
                }
                i--; // After coming out of the loop, we are missing the current one, so reducing the value of "i".
                if(sign=='+'){
                    stack.push(num);
                }
               else if(sign=='-'){
                    stack.push(-num);
                }
                else if(sign=='*'){
                    int temp = stack.pop();
                    temp = temp*num;
                    stack.push(temp);
                }
                else if(sign=='/'){
                    int temp = stack.pop();
                    temp = temp/num;
                    stack.push(temp);
                }
            }else if(s.charAt(i)!=' '){
                sign = s.charAt(i);
            }
        }
        while(!stack.isEmpty()){
            res = res+stack.pop();
        }
        return res;
    }
}

-----------------------------------V3-------------------------------------------------------------
 //Applicable for all characters.
     
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
                    num = 10*num+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                cal(stack,num,sign);
            } else if(s.charAt(i)=='('){
                stackP.push(new Pair(stack,sign));
                sign = '+';
                stack = new Stack<>();
            } else if(s.charAt(i)==')'){
                int num = 0;
                while(!stack.isEmpty()){
                    num = num+stack.pop();
                }
                Pair p1 = stackP.pop();
                stack = p1.st;
                sign = p1.sign;
                cal(stack,num,sign);
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
    
    public void cal(Stack<Integer> stack, int num, char sign){ // Applicable for all signs including (, ).
        if(sign=='+'){
                    stack.push(num);
                }
               else if(sign=='-'){
                    stack.push(-num);
                }
                else if(sign=='*'){
                    int temp = stack.pop();
                    temp = temp*num;
                    stack.push(temp);
                }
                else if(sign=='/'){
                    int temp = stack.pop();
                    temp = temp/num;
                    stack.push(temp);
                }
    }
}

class Pair{
    Stack<Integer> st;
    char sign;
    Pair(Stack<Integer> stack, char ch){
        st = stack;
        sign = ch;
    }
}


/**
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5

*/
