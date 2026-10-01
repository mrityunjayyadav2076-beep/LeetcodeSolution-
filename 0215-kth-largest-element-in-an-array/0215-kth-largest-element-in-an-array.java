class Solution 
{
    private int[] nums;
    private int targetIndex; 
    public int findKthLargest(int[] nums, int k) 
    {
        this.nums = nums;
        this.targetIndex = nums.length - k;
        return quickSelect(0, nums.length - 1);
    }

    private int quickSelect(int left, int right) 
    {
        if (left == right) 
        {
            return nums[left];
        }
      
        int i = left - 1;
        int j = right + 1;
      
        int pivot = nums[(left + right) >>> 1];

        while (i < j) 
        {
            while (nums[++i] < pivot) 
            {
            }
          
            while (nums[--j] > pivot) 
            {
            }
          
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
      
        if (j < targetIndex) 
        {
            return quickSelect(j + 1, right);
        }
        return quickSelect(left, j);
    }
}
