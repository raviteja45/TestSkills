class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }
    public boolean backTrack(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char m='1';m<='9';m++){
                        if(isValid(i,j,board,m)){
                            board[i][j] = m;
                            if(backTrack(board)){
                               return true; 
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(int row,int col,char[][] board, char c){
       for(int i = 0; i < 9; i++) {
            if(board[i][col] == c){
                return false;
            }  
            if(board[row][i] == c){
                return false;
            } 
          if(
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
