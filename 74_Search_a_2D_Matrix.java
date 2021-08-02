class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int i = 0;
        int j=matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            
            if(target>matrix[i][j]){
                i++;
            }
            else if(target<matrix[i][j]){
                j--;
            } else if(target == matrix[i][j]){
                return true;
            }
        }
        return false;
    }
}


/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

*/
