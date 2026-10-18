class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0];  
        int minEnding = nums[0];  
        int globalMax = nums[0];  
      
        for (int i = 1; i < nums.length; i++) {
            int Max = maxEnding;
            int Min = minEnding;
          
            maxEnding = Math.max(nums[i],  Math.max(Max * nums[i], Min * nums[i]));
          
            minEnding = Math.min(nums[i], Math.min(Max * nums[i], Min * nums[i]));
          
            globalMax = Math.max(globalMax, maxEnding);
        }
      
        return globalMax;
    }
}