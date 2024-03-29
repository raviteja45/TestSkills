class Solution {
    public int twoCitySchedCost(int[][] costs) { // As sorting involved, TC - O(nlogn)
        int[] temp = costs[1];
        //Sorting basing on visiting city B over City A - (Cost A - Cost B)
       /** Arrays.sort(costs,(a,b)->{
            System.out.println("First "+(a[0]-a[1]));
            System.out.println("Second "+(b[0]-b[1]));
            System.out.println("Res "+((a[0]-a[1])-(b[0]-b[1])));
            return (a[0]-a[1])-(b[0]-b[1]);
        });*/
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));
        int total_sum = 0;
        for(int i=0;i<costs.length;i++){
            if(i<costs.length/2){
                total_sum = total_sum+costs[i][0];//First half is visitng A, so ith row,0 column
            }else{
                total_sum = total_sum+costs[i][1];//second half is visitng B
            }
            
        }
        return total_sum;
    }
}

/**
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

 

Example 1:

Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
Example 2:

Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
Example 3:

Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086
*/
