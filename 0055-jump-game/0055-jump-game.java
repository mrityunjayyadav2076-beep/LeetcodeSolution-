class Solution {
    public boolean canJump(int[] nums) {
        int A = 0;
      
        for (int i = 0; i < nums.length; i++) {
            if (A < i) {
                return false;
            }
            A = Math.max(A, i + nums[i]);
        }
        return true;
    }
}
