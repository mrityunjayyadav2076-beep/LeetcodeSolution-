class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length<3){
            return false;
        }
        int numsk = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i= nums.length-1; i>=0; i--){
            if(nums[i]<numsk){
                return true;
            }
            while (!stack.isEmpty() && nums[i]> stack.peek()){
                numsk = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}