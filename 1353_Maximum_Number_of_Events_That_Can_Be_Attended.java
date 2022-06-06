class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));//priority Queue by events expiry (end time)
        Queue<Integer> pq = new PriorityQueue<>();
        int i=0;
        int n = events.length;
        int d=0;
        int res = 0;
        while(!pq.isEmpty()||i<n){
             //remove exired events that we couldn't attend any more
            while(!pq.isEmpty()&&pq.peek()<d){
                pq.poll();
            }
            //add all the events happening on day d
            while(i<n&&events[i][0]==d){
                pq.add(events[i][1]);
                i++;
            }
            //attend event which expires first
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            d++;
        }
        return res;
    }
}


/**
Read this line carefully:
You can attend an event i at any day d where startTimei <= d <= endTimej

Event can be completed in one day.
e.g. Suppose you have event [1,2] then we can attend this either on day 1 or on day2.
The day should be between the start time and end time.
if we have event [2,3] then we can attend it on day 2 or day 3.

For example:
[[1,2],[2,3],[3,4],[1,2]]

As per above:
Attend [1, 2] on day 1
Attend [1, 2] on day 2
Attend [2, 3] on day 3
Attend [3, 4] on day 4 */

/**
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
*/
