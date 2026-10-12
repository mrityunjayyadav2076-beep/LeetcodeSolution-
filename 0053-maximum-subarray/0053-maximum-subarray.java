class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        int maxSum = nums[0];
        int currentSum = nums[0];
      
        for (int i = 1; i < nums.length; i++) 
        {
            currentSum = Math.max(currentSum, 0) + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
