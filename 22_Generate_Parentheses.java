class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        backTracking(res,0,0,b,n);
        return res;
    }
    public void backTracking(List<String> res,int open,int close, StringBuilder b,int n){
        if(b.length()==2*n){
            res.add(b.toString());
        }else{
      if(open<n){
            b.append("(");
            backTracking(res,open+1,close,b,n);
            b.deleteCharAt(b.length()-1);
        }
            if(close<open){
                b.append(")");
                backTracking(res,open,close+1,b,n);
                b.deleteCharAt(b.length()-1);
            }
        }
    }
}

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

*/
