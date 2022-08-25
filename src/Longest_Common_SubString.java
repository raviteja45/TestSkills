public int LCS(String input1, String input2) {
			int result = 0;
			int[][] dp = new int[input1.length() + 1][input2.length() + 1];
			for (int i = 1; i <= input1.length(); i++) {
				for (int j = 1; j <= input2.length(); j++) {
					if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
						result = Integer.max(result, dp[i][j]);
					} 
				}
			}
			return result;
		}

/**
System.out.println(t1.LCS("abcd", "xabc")); //3
SubString - should be in sequence
*/
