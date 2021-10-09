package slash.practice;

import java.util.Arrays;

public class Longes {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("val "+tes(4,prices)); //10
	}
	
	public static int tes(int noOfCuts,int[] val) {
		int[]dp = new int[noOfCuts+1];
		Arrays.fill(dp,-1);
		dp[0] = 0;
		for(int i=1;i<=noOfCuts;i++) {
			for(int j=1;j<=i;j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+val[j-1]);
			}
		}
		return dp[noOfCuts];
	}
}

length[] = [1, 2, 3, 4, 5, 6, 7, 8]
price[] = [1, 5, 8, 9, 10, 17, 17, 20]
 
Rod length: 4
 
 
Best: Cut the rod into two pieces of length 2 each to gain revenue of 5 + 5 = 10
 
Cut           Profit
4                9
1, 3            (1 + 8) = 9
2, 2            (5 + 5) = 10
3, 1            (8 + 1) = 9
1, 1, 2         (1 + 1 + 5) = 7
1, 2, 1         (1 + 5 + 1) = 7
2, 1, 1         (5 + 1 + 1) = 7
1, 1, 1, 1      (1 + 1 + 1 + 1) = 4
