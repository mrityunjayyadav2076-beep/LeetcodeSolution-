class Solution 
{    
    public void nextPermutation(int[] nums) 
    {
        int length = nums.length;
      
        int pivotIndex = length - 2;
        while (pivotIndex >= 0) {
            if (nums[pivotIndex] < nums[pivotIndex + 1]) 
            {
                break;
            }
            pivotIndex--;
        }
      
        if (pivotIndex >= 0) 
        {
            int swapIndex = length - 1;
            while (swapIndex > pivotIndex) 
            {
                if (nums[swapIndex] > nums[pivotIndex]) 
                {
                    swap(nums, pivotIndex, swapIndex);
                    break;
                }
                swapIndex--;
            }
        }
      
        int left = pivotIndex + 1;
        int right = length - 1;
        while (left < right) 
        {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
  
    private void swap(int[] nums, int i, int j) 
    {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
