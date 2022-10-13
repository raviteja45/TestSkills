class Solution {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[floors + 1][eggs + 1];
        int m = 0;
        while (dp[m][eggs] < floors) {
            m++;
            for (int k = 1; k <= eggs; k++)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }
}

/**
You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.

Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.

 

Example 1:

Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
Example 2:

Input: k = 2, n = 6
Output: 3
Example 3:

Input: k = 3, n = 14
Output: 4
*/

/**
He has turned the problem around from
"How many moves do you need to check N floors if you have K eggs"
to:
"How many floors can you check given M moves available and K eggs".

If you can solve this second problem than you can just increase the moves M one by one until you are able to check a number of floors larger or equal to the number N which the problem requires.
He then defined
dp[M][K] as the maximum number of floors that you can check within M moves given K eggs

A move essentially is dropping an egg and it either breaks or doesn't break.
Case A: The egg breaks and now you have spent 1 move (M=M-1) and also lost 1 egg (K=K-1). You can still check dp[M-1][K-1] floors, with your remaining eggs and moves.
Case B: The egg remains and you only loose one move (M=M-1). You can still check dp[M-1][K] floors.
Additionally you just checked a floor by dropping the egg from it.
Therefore dp[M][K] = dp[M - 1][k - 1] + dp[M - 1][K] + 1
As you can see we can easily calculate how many floors we can check in M moves if we know how many floors we can check in M-1 moves.

However we not only have to know how many floors we can can check with one move less, but also how many we can check with one move and one egg less. Therefore we have to calculate how many moves we can check for all number off eggs from 1 to K.

An example:
N = 6 and K = 2
Turn the problem around: How many floors can you check with 2 eggs and M moves:

Solve for M=1, K=1,2
you can only check 1 floor (since afterwards you have no more moves left)

Solve for M=2, K=1
Case A: Your egg breaks, you have no more eggs left and can check nothing. dp[M=1,K=0]=0
Case B: your egg survives and you can use it to test an additional floor above the floor you just tested. dp[M=1,K=1]=1
dp[2][1]=dp[1][0]+dp[1][1]+1=0+1+1=2

Solve for M=2, K=2
Case A: Your egg breaks: you have 1 move left and 1 egg. Since you know that the floor F where the eggs break is below the floor you just tested you can now check dp[M=1,K=1] floors below you, with only 1 move left you check 1 additional floor below. dp[M=1,K=1]=1
Case B: Your eggs survives and you start to search above the current floor. dp[1][2] is still only 1 move and we can check 1 floor. dp[1][2]
dp[2][2]=1+1+1=3

Solve for M=3, K=1
Case A: Your egg breaks and you are out of eggs, no chance to check anything anymore
Case B: Your egg survives and you can use it for 2 more moves dp[2][1], which as we established above is enough to check 2 floors.
dp[3][1]=0+2+1=3

Solve for M=3, K=2
Case A: Your egg breaks and you check dp[2][1]=2 additional floors
Case B: Your egg survives and you check dp[2][2]=3 additional floors
dp[3][2]=2+3+1=6

As you can see 3 moves and 2 eggs allows you to check 6 floors. Which answers the original question how many moves you need to check 6 floors given 2 eggs,
The answer is 3

I hope this helps to make it more clear.
*/
