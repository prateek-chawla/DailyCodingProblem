
/*
  Given an array of numbers representing the stock prices of a company in chronological order
  and an integer k, return the maximum profit you can make from k buys and sells. 
  You must buy the stock before you can sell it, and you must sell the stock before
  you can buy it again.

For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.

*/




class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        if(n==0 || k==0)
            return 0;
        int dp[k+1][n];

        // Initialiing with 0

        for(int i=0;i<=k;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
  
/* dp[i][j] will represent max profit with i transactions until j index
  as any index can be potential seller you just have to check from m=0...j-1 max profit 
   you can get and for that index as k-1 th transaction should be completed
   so added with dp[i-1][m] as no two buy can take place together so a sell should have 
   been completed at that time. Time complexity-O(n^2*k)
   to do better than this as we are checking again and again from 0-j max value we can get
   we can store that to do in o(1) as we have to calculate max value of
   price[j] - [price [m] + dp[i-1][m]] where last two values will be constant for further j so we
   can find max till that point. 
   new time complexity- o(n*k);
   */

     // start with 1 as single index can't complete buy as well as sell and 0 sell won't
     // give any profit

        for(int i=1;i<=k;i++){
            int max_diff=-prices[0];
            for(int j=1;j<n;j++){
                dp[i][j]=max(dp[i][j-1],max_diff+prices[j]);
                max_diff=max(max_diff,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }
};