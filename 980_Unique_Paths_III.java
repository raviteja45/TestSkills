class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    count++;
                }
                if(grid[i][j]==1){
                  x = i;
                  y = j;
                }
            }
        }
        return checkAll(grid,x,y,count,-1);
    }
    
    public int checkAll(int[][]grid,int x,int y, int count,int tempCount){
        if(x>=grid.length||y>=grid[0].length||x<0||y<0||grid[x][y]==-1){
            return 0;
        }
        if(grid[x][y]==2){
            if(count==tempCount){ // Here we are checking all the "0" covered or not. If covered, then we will consider as "1", else it will be "0"
                return 1;
            }else{
                return 0;
            }
        }
        int temp = grid[x][y];
        grid[x][y] = -1;
        int total = checkAll(grid,x+1,y,count,tempCount+1)
        +checkAll(grid,x-1,y,count,tempCount+1)
        +checkAll(grid,x,y+1,count,tempCount+1)
        +checkAll(grid,x,y-1,count,tempCount+1);
        grid[x][y] = temp;
        return total;
    }
}


/**
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
*/
