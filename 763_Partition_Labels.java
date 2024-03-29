class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int end=0;
        int start = 0;
        for(int i=0;i<S.length();i++){
            int lastIndex = S.lastIndexOf(S.charAt(i));
            end = Math.max(end,lastIndex);
            if(i==end){
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}

//A string S of lowercase English letters is given. 
//We want to partition this string into as many parts as possible 
//so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

//Example 1:

//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
