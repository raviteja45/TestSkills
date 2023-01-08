class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length];
        for(int i=0;i<mat.length;i++){
            int m1 = i;
            int m2 = 0;
            while(m1>=0){
                System.out.print(mat[m1][m2]); // Print all the elements starting from row1, row2, row3
                m1 = m1-1; // go to previous row
                m2 = m2+1; // go to next column
            }
        }
        System.out.println("End");// 1  42 753  
        for(int i=1;i<mat[0].length;i++){ 
            int m1 = mat.length-1;
            int m2 = i;
            while(m2<mat[0].length){
                System.out.print(mat[m1][m2]); //start taking from col2, col3 
                m1 = m1-1;
                m2 = m2+1;
            }
            System.out.println("/n");
        } // 86    9 
        return null;
    }
}

[1. 2. 3 - row1
 4. 5. 6 - row2
 7. 8  9] - row3
 col1 col2 col3
Diagonal - 1,42,753,86,9.
  
https://www.youtube.com/watch?v=T8ErAYobcbc
