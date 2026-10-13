class Solution {
    public int majorityElement(int[] nums) {
        int A = 0;      
        int B = 0;  

        for (int num : nums) {
            if (A == 0) {
                B = num;
                A = 1;
            } else {
                if (B == num) {
                    A++;
                } else {
                    A--;
                }
            }
        }
        return B;
    }
}
