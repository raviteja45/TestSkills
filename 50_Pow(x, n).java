class Solution { // Time Limit Exceeding 
    public double myPow(double x, int n) {
        double res = 1;
        int k = n;
        if(k<0){
            k = k*-1;
        }
        for(int i=0;i<k;i++){
            res = res*x;
        }
        if(n<0){
            res = 1/res;
        }
        return res;
    }
}

--------------------------V2---------------------------

  class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long k = n;
        if(k<0){
            k = k*-1;
        }
        while(k>0){
            if(k%2==1){
                res = res*x;
                k--;
            }else{
                 x = x*x;
                k = k/2;
            }
        }
        if(n<0){
            res = 1/res;
        }
        return res;
    }
}


/**
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/
