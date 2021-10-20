class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int len = grid.length;
        int height = grid[0].length;
        boolean[][] isVisited = new boolean[len][height];
        Stack<String> stack = new Stack<>();
        for(int i=0;i<len;i++){
            for(int j=0;j<height;j++){
                isVisited[i][j] = false;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<height;j++){
                if(!isVisited[i][j]&&grid[i][j]=='1'){
                    stack.push(i+","+j);
                    dfs(isVisited,stack,grid);
                    result++;
                }
            }
        }
        return result;
    }
    
    public void dfs(boolean[][] isVisited,Stack<String> stack,char[][] grid){
        int len = grid.length;
        int height = grid[0].length;
        while(!stack.isEmpty()){
            String val = stack.pop();
            int row = Integer.parseInt(val.split(",")[0]);
            int column = Integer.parseInt(val.split(",")[1]);
            if(row<0||column<0||row>=len||column>=height||grid[row][column]!='1'||isVisited[row][column]){
                continue;
            }
            isVisited[row][column] = true;
            stack.push(row+","+(column-1));
            stack.push(row+","+(column+1));
            stack.push((row-1)+","+column);
            stack.push((row+1)+","+column);
        }
    }
}


/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

*/
