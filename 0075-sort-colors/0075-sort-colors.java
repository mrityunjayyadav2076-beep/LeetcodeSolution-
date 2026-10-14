class Solution 
{
    public void sortColors(int[] nums) 
    {
        int leftBoundary = -1;
      
        int rightBoundary = nums.length;
      
        int current = 0;
      
        while (current < rightBoundary) 
        {
            if (nums[current] == 0) 
            {
                leftBoundary++;
                swap(nums, leftBoundary, current);
                current++;
            } else if (nums[current] == 2) 
            {
                rightBoundary--;
                swap(nums, rightBoundary, current);
            } else {
                current++;
            }
        }
    }
  
    private void swap(int[] nums, int i, int j) 
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
