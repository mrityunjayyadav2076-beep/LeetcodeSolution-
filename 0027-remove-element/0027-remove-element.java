class Solution {
    public int removeElement(int[] nums, int val) {
        int B = 0;
        for (int currentElement : nums) {
            if (currentElement != val) {
                nums[B] = currentElement;
                B++;
            }
        }
        return B;
    }
}
