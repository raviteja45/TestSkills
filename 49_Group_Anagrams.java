class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
           char[] c = s.toCharArray();
            Arrays.sort(c);
            String val = String.valueOf(c);
            if(!map.containsKey(val)){
                List<String> x = new ArrayList<>();
                x.add(s);
                map.put(val,x);
            }else{
                List<String> temp = map.get(val);
                temp.add(s);
                map.replace(val,temp);
            }
        }
        return new ArrayList<>(map.values());
    }
}


/**
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

*/
