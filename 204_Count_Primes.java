class Solution {
    public int countPrimes(int n) {
        int fin = 0;
        if(n==0||n==1||n==2)
			return 0;
        if(n==3)
            return 1;
        for(int i=2;i<n;i++){
            boolean res = true;
            for(int j=2;j*j<=i;++j ){
                if(i%j==0){
                    res = false;
                    break;
                }
            }
            if(res){
                fin = fin+1;
            }
        }
        return fin;   
    }
}

/**
Count the number of prime numbers less than a non-negative number, n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0

*/
