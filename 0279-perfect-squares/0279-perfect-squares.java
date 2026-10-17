class Solution {
    public int numSquares(int n) {
        int maxSquareRoot = (int) Math.sqrt(n);
      
        int[][] dp = new int[maxSquareRoot + 1][n + 1];
      
        for (int[] row : dp) {
            Arrays.fill(row, 1 << 30); 
        }
      
        dp[0][0] = 0;
      
        for (int i = 1; i <= maxSquareRoot; i++) {
            int currentSquare = i * i; 
          
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
              
                if (j >= currentSquare) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - currentSquare] + 1);
                }
            }
        }
      
        return dp[maxSquareRoot][n];
    }
}
