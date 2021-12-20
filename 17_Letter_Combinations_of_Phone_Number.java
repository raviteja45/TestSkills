class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
       Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
	    map.put('3', "def");
	    map.put('4', "ghi");
	    map.put('5', "jkl");
	    map.put('6', "mno");
	    map.put('7', "pqrs");
	    map.put('8', "tuv");
	    map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i=0;i<digits.length();i++){
            List<String> temp = new ArrayList<>();
            String u = map.get(digits.charAt(i));
            for(String l:res){
                for(int k=0;k<u.length();k++){
                temp.add(new StringBuilder(l).append(u.charAt(k)).toString());
                    
            }
            }
            res.clear();
            res.addAll(temp);
        }
        return res;
    }
}

----------- V2 version--------------
	
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
       Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
	    map.put('3', "def");
	    map.put('4', "ghi");
	    map.put('5', "jkl");
	    map.put('6', "mno");
	    map.put('7', "pqrs");
	    map.put('8', "tuv");
	    map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        backTracking(digits,map,res,0,sb);
        return res;
    }
    public void backTracking(String digits,Map<Character,String>map,List<String> res, int index, StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
        }else{
            for(int i=index;i<digits.length();i++){
                String s = map.get(digits.charAt(i));
                for(int k = 0;k<s.length();k++){
                    sb.append(s.charAt(k));
                    backTracking(digits,map,res,i+1,sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}

/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
*/
