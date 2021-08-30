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
