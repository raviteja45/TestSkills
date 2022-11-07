class Solution { // Passing 135 test cases out of 138
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int current_longest = checkAll(matrix,i,j,-1);
                max = Math.max(max,current_longest);
            }
        }
        return max;
    }

    public int checkAll(int[][] matrix,int i,int j, int curr){
        if(i>=matrix.length||j>=matrix[0].length||i<0||j<0||matrix[i][j]<=curr){
            return 0;
        }
        int res = 0;
        res = Math.max(res,checkAll(matrix,i+1,j,matrix[i][j]));
        res = Math.max(res,checkAll(matrix,i-1,j,matrix[i][j]));
        res = Math.max(res,checkAll(matrix,i,j+1,matrix[i][j]));
        res = Math.max(res,checkAll(matrix,i,j-1,matrix[i][j]));
        res++;
        return res;
    }
}

-------------------------------V2-------------------------------------------------
  
  class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int current_longest = checkAll(matrix,i,j,-1,memo);
                max = Math.max(max,current_longest);
            }
        }
        return max;
    }

    public int checkAll(int[][] matrix,int i,int j, int curr,int[][] memo){
        if(i>=matrix.length||j>=matrix[0].length||i<0||j<0||matrix[i][j]<=curr){
            return 0;
        }
        if(memo[i][j]>0){
            return memo[i][j];
        }
        int res = 0;
        res = Math.max(res,checkAll(matrix,i+1,j,matrix[i][j],memo));
        res = Math.max(res,checkAll(matrix,i-1,j,matrix[i][j],memo));
        res = Math.max(res,checkAll(matrix,i,j+1,matrix[i][j],memo));
        res = Math.max(res,checkAll(matrix,i,j-1,matrix[i][j],memo));
        res++;
        memo[i][j] = res;
        return res;
    }
}


/**
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
*/

