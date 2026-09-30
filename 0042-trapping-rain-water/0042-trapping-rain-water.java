class Solution {
    public int trap(int[] height) {
        int n = height.length;
      
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
      
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
      
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i - 1]);
        }
      
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
      
        return totalWater;
    }
}
