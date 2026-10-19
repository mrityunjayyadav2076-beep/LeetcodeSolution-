class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
      
        if (total % 2 == 1) {
            return false;
        }
      
        int n = nums.length;
        int Sum = total / 2;
      
        boolean[][] dp = new boolean[n + 1][Sum + 1];
      
        dp[0][0] = true;
      
        for (int i = 1; i <= n; i++) {
            int Num = nums[i - 1];
          
            for (int j = 0; j <= Sum; j++) {
                dp[i][j] = dp[i - 1][j];
              
                if (j >= Num) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - Num];
                }
            }
        }
      
        return dp[n][Sum];
    }
}
