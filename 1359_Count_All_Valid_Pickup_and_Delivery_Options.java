class Solution {
    public int countOrders(int n) {
        long res = 1;
        for(int i=1;i<=n;i++){
            res = res*i; // All the pickups can be formed in any way, so its a simple permutation. If there are n items, its n!.
            res = res*(2*i-1); // All the delivery should be in the right format (p1 should be before d1 etc). So, its 2n-1.
            res = res%1000000007;
        }
        return (int)res;
    }
}


/**
Given n orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
Example 2:

Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
Example 3:

Input: n = 3
Output: 90

*/
