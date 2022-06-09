class Solution {
    public int minPathSum(int[][] grid) {
        int row = 0;
        int column = 0;
        for(int i=1;i<grid[0].length;i++){
            grid[0][i] = grid[0][i]+grid[0][i-1];//Sum of 0th row((0,0)+(0,1) etc)
        }
        for(int j=1;j<grid.length;j++){
            grid[j][0] = grid[j][0]+grid[j-1][0];//Sum of 0th column((1,0)+(1,1) etc)
        }
        // Check the remaining block. Above two are first row and first column.
        // to find the valud of 1st row, 1st column, we need to add 0th row 1st column
        // 1st row 0th column and contine the process for all remaining blocks.
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j] = grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}


/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
*/
