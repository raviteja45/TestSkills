class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> chars = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(!chars.isEmpty()&&chars.peek()==s.charAt(i)){
                counts.push(counts.peek()+1);
            }else{
                counts.push(1);
            }
            chars.push(s.charAt(i));
            if(counts.peek()==k){
                for(int j=0;j<k;j++){
                    counts.pop();
                    chars.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!chars.isEmpty()){
            sb.append(chars.pop());
        }
        return sb.reverse().toString();
        
    }
}


/**
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

*/
