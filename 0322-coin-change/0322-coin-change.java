class Solution {
    public int coinChange(int[] coins, int amount) {
        final int INF = 1 << 30;
      
        int Coins = coins.length;
        int Amount = amount;
      
        int[][] dp = new int[Coins + 1][Amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
      
        dp[0][0] = 0;
      
        for (int i = 1; i <= Coins; i++) {
            for (int j = 0; j <= Amount; j++) {
                dp[i][j] = dp[i - 1][j];
              
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
      
        return dp[Coins][Amount] >= INF ? -1 : dp[Coins][Amount];
    }
}
