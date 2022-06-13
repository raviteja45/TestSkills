class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       /** Queue<Integer> q = new PriorityQueue<>((o1,o2)->o2-o1);
        int[] res1 = new int[nums.length-k+1];
        int j = 0;
        boolean u = false;
        int y = 0;
       for(int i=0;i<nums.length;i++){
            int m = i;
            while(j!=k){
                if(i<nums.length){
                    q.add(nums[i]);
                }else{
                    u = true;
                    break;
                }
                j++;
                i++;
            }
            if(u){
                break;
            }
            j=0;
            i = m;
            res1[i] = q.poll();
            q.clear();
        }
        
        
        return res1;*/
        
         if(nums == null || k <= 0){
             return new int [0];
         } 
    int [] arr = new int[nums.length - k + 1];
    int in = 0;
    Deque<Integer> dq = new ArrayDeque<>();
    for(int i = 0; i < nums.length; i++){
        while(!dq.isEmpty() && dq.peek() < i - k + 1)
            dq.poll();
        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) 
            dq.pollLast();
        dq.add(i);
        if(i >= k - 1) {
            arr[in] = nums[dq.peek()];
             in++;
        }
            
    }
    return arr;
    }
}
