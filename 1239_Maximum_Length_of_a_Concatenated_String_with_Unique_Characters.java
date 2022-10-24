class Solution {
    int result = 0;
    public int maxLength(List<String> arr) {
        backTracking(arr,"",0);
        return result;
    }
    
    public void backTracking(List<String> arr, String path, int index){
        boolean isUnique = checkUnique(path);
        if(isUnique){
            result = Math.max(result,path.length());
        }
        if(!isUnique||index==arr.size()){
            return;
        }
        for(int i=index;i<arr.size();i++){
            backTracking(arr,path+arr.get(i),i+1);
        }
    }
    
    public boolean checkUnique(String path){
        Set<Character> set = new HashSet<>();
        for(char c:path.toCharArray()){
            boolean t = set.add(c);
            if(!t){
                return false;
            }
        }
        return true;
    }
}

/**
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters
*/
