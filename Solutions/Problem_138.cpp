/*
Find the minimum number of coins required to make n cents.

You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
*/


class Solution {
public:
   /* int memoized(vector<int>&coins, int amount,vector<int> &dp){
        if(amount<0)
            return INT_MAX;
        if(dp[amount]!=INT_MAX)
            return dp[amount];
        for(int i=0;i<coins.size();i++)
        {if(amount-coins[i]>=0)
            { int val=memoized(coins,amount-coins[i],dp);
                if(val!=INT_MAX)
                    dp[amount]=min(val+1,dp[amount]);
            }
        }
        return dp[amount];
    }
    */
    int coinChange(vector<int>& coins, int amount) {
      int n=coins.size();
        vector<int> dp(amount + 1,INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i) {
                    if(dp[i - coins[j]]!=INT_MAX)
                        dp[i] = min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if(dp[amount]==INT_MAX)
            return -1;
        return dp[amount];
    }
};