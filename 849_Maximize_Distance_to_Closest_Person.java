class Solution {
    public int maxDistToClosest(int[] seats) {
        int currDistance = 0;
        int maxDistance = 0;
        boolean isFirst = true;
         for(int i=0;i<seats.length;i++){
             if(seats[i]==0){
                 currDistance = currDistance+1;
                 if(i==seats.length-1){
                     currDistance = currDistance*2;
                 }
             }else{
                 maxDistance = Math.max(currDistance,maxDistance);
                 if(isFirst){
                     maxDistance = maxDistance*2;
                     isFirst = false;
                 }
                 currDistance = 0;
             }
             
         }
        maxDistance = Math.max(currDistance,maxDistance);
        return (maxDistance+1)/2;
    }
}


/*
        Approach: Find max number of consecutive zeros (empty seats). The optimal position will be the middle position
                  of the longest consecutive empty seats. We'll call it a batch. Calculate the middle position by      (maxDistance + 1)/2
        Special case: For starting and ending batchs, imagine equal number of vacant seats outside both sides.
                  Eg: [0,0,1] -> 0,0,[0,0,1]   ;    [1,0,1,0,0,0] ->   [1,0,1,0,0,0],0,0,0
                  To handle the cases, we'll double ( *=2 ) the number of vacant seats during calculation.
        */
