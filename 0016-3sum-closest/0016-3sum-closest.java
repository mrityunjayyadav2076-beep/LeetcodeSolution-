class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
      
        int closestSum = 1 << 30;
        int arrayLength = nums.length;
      
        for (int i = 0; i < arrayLength; ++i) {
            int left = i + 1;
            int right = arrayLength - 1;
          
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
              
                if (currentSum == target) {
                    return currentSum;
                }
              
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
              
                if (currentSum > target) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
      
        return closestSum;
    }
}
