class Solution {
    public int largestRectangleArea(int[] heights) {
       Stack<Integer> stack = new Stack<>();
       int max = 0;
        for(int i=0;i<=heights.length;i++){
            int current = (i==heights.length)?0:heights[i];
            while(!stack.isEmpty()&&current<heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty()?i:i-stack.peek()-1;// right-left-1
                int curr_area = height*width;
                max = Math.max(max,curr_area);
            }
            stack.push(i);
        }
        return max;
    }
}


/**
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
*/
