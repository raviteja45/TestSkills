class Solution { // Same as histogram rectangle
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int  maxWater = 0;
        for(int i=0;i<=height.length;i++){
            int current = (i==height.length)?0:height[i];
            while(!stack.isEmpty()&&current>height[stack.peek()]){ // here its reverse of histogram <, >
                int height1 = height[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }
                int bredth  = i-stack.peek()-1;//right-left-1
                int water_filled = bredth*(Math.min(height[stack.peek()],current)-height1); // min (left, right). height1 is the height of the in-between block.
                maxWater = maxWater+water_filled;
            }
            stack.push(i);
        }
        return maxWater;
    }
}

https://www.youtube.com/watch?v=EdR3V5DBgyo&ab_channel=AlgorithmsMadeEasy
