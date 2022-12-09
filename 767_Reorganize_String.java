class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        pq.addAll(map.keySet());
        Character prev = null;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            map.put(c,map.get(c)-1);
            sb.append(c);
            if(prev!=null){
                pq.add(prev);
            }
            if(map.get(c)!=0){
                prev = c;
            }else{
                prev = null;
                map.remove(c);
            }
        }
        return sb.toString().length()==s.length()?sb.toString():"";
    }
}


/**
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
*/
