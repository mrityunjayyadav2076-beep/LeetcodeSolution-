class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
      
        int  A= 0;
      
        int B = 0;
      
        for (int i = 0; i < nums.length - 1; i++) {
            A = Math.max(A, i + nums[i]);
          
            if (i == B) {
                jumps++;
              
                B = A;
            }
        }
      
        return jumps;
    }
}
