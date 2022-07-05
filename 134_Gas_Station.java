class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int res = 0;
        int tot = 0;
        for(int i=0;i<gas.length;i++){
            sum = sum+(gas[i]-cost[i]); // We check the gas-cost value;
            if(sum<0){ // if the sum is -ve, we should try next gas stattion. we reset to next 
                       // gas station.
                tot = tot+sum;
                sum = 0;
                res = i+1; // resetting to next gas station.
            }
           // System.out.println("tot is "+tot);
        }
        tot = tot+sum;
        //System.out.println("Fin tot "+tot);
        return tot<0?-1:res; //add up all of the left gas to total. If it's negative finally, return -1 since it's impossible to finish.
    }
}

/**
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

 

Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
*/