class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Queue<Integer> q = new PriorityQueue<>();
        for(int n:hand){
            q.add(n);
        }
        while(!q.isEmpty()){
            int head = q.poll();
            for(int i=1;i<groupSize;i++){
             //   System.out.println("Head "+head+" "+(head+i));
                if(!q.remove(head+i)){ // If there is no consecutive number to delete, its fail.
                    return false;
                }
            }
           // System.out.println("Completed");
        }
        return true;
    }
}

/**
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.
*/
