class Solution {
    public int firstMissingPositive(int[] nums) {
        int arrayLength = nums.length;
      
        for (int i = 0; i < arrayLength; i++) {
            while (nums[i] > 0 && 
                   nums[i] <= arrayLength && 
                   nums[i] != nums[nums[i] - 1]) {
                int targetIndex = nums[i] -1;
                swap(nums, i, targetIndex);
            }
        }
      
        for (int j = 0; j < arrayLength; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
      
        return arrayLength + 1;
    }
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
