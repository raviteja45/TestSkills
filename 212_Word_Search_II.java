class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for(String word:words){
            if(searchPrimary(board,word)){
                result.add(word);
            }
        }
        return result;
    }
    
    public boolean searchPrimary(char[][] board,String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][]board,String word,int row, int column, int index){
        if(word.length()==index){
            return true;
        }
        if(row<0||column<0||row>=board.length||column>=board[0].length||board[row][column]!= word.charAt(index)){
            return false;
        }
        if(board[row][column]=='#'){
            return false;
        }
        char c = board[row][column];
        board[row][column] = '#';
        boolean res = search(board,word,row+1,column,index+1)||
                      search(board,word,row-1,column,index+1)||
                      search(board,word,row,column+1,index+1)||
                      search(board,word,row,column-1,index+1);
        board[row][column] = c;
        return res;
    }
}


/**
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

*/
