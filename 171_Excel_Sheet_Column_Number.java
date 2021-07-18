class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        
        for(int i=0;i<columnTitle.length();i++){
            res = 26*res+(columnTitle.charAt(i)-'A'+1);
        }
        return res;
    }
}

/**
Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
Example 4:

Input: columnTitle = "FXSHRXW"
Output: 2147483647


*/
