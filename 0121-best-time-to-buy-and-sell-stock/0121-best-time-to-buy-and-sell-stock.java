class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int currentPrice : prices){
             maxProfit = Math.max(maxProfit, currentPrice-minPrice);
             minPrice = Math.min(minPrice, currentPrice);
        }
        return maxProfit;
    }
}