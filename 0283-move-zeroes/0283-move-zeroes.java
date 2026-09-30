class Solution {
    public void moveZeroes(int[] nums) {
        int nZI = 0;
        int arrayLength = nums.length;

        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {

            if (nums[currentIndex] != 0) {
                int temp = nums[currentIndex];
                nums[currentIndex] = nums[nZI];
                nums[nZI] = temp;

                nZI++;
            }
        }
    }
}
