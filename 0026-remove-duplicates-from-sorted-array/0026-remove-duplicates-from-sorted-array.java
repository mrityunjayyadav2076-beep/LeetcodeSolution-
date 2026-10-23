class Solution {
    public int removeDuplicates(int[] nums) {
        int A = 0;
      
        for (int currentElement : nums) {
            if (A == 0 || currentElement != nums[A - 1]) {
                nums[A] = currentElement;
                A++;
            }
        }
      
        return A;
    }
}
