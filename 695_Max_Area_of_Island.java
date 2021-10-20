class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
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
                if(!isVisited[i][j]&&grid[i][j]==1){
                    stack.push(i+","+j);
                    int x = dfs(isVisited,stack,grid);
                    res = Math.max(res,x);
                   
                }
            }
        }
        return res;
    }
    
    public int dfs(boolean[][] isVisited,Stack<String> stack,int[][] grid){
        int len = grid.length;
        int height = grid[0].length;
        int x = 0;
        while(!stack.isEmpty()){
            String val = stack.pop();
            int row = Integer.parseInt(val.split(",")[0]);
            int column = Integer.parseInt(val.split(",")[1]);
            if(row<0||column<0||row>=len||column>=height||grid[row][column]!=1||isVisited[row][column]){
                continue;
            }
            isVisited[row][column] = true;
            x = x+1;
            stack.push(row+","+(column-1));
            stack.push(row+","+(column+1));
            stack.push((row-1)+","+column);
            stack.push((row+1)+","+column);
        }
        return x;
    }
}

/**
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

*/
