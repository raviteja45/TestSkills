class Solution {
    public List<Integer> partitionLabels(String S) {
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),S.lastIndexOf(S.charAt(i)));
        }
        for(int i=0;i<S.length();i++){
            int last = map.get(S.charAt(i));
            end  = Math.max(end,last);
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
