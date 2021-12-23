class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board,int row, int column, String word,int index){
        if(index==word.length()){
            return true;
        }
        if(row<0||column<0||row>=board.length||column>=board[0].length||board[row][column]!=word.charAt(index)){
            return false;
        }
        if(board[row][column]=='#'){
            return false;
        }
        char c  = board[row][column];
        board[row][column] = '#';
        boolean res = search(board,row+1,column,word,index+1)||
                      search(board,row-1,column,word,index+1)||
                      search(board,row,column+1,word,index+1)||
                      search(board,row,column-1,word,index+1);
        board[row][column] = c;
        return res;
    }
}

/**
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
*/
