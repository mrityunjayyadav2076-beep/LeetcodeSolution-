class Solution {
   
    public int[] maxSlidingWindow(int[] nums, int k) {
       
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];  
            }
            return b[0] - a[0];  
        });
      
        int arrayL = nums.length;
      
        for (int i = 0; i < k - 1; i++) {
            maxHeap.offer(new int[] {nums[i], i});
        }
      
        int[] result = new int[arrayL - k + 1];
        int Index = 0;
      
        for (int i = k - 1; i < arrayL; i++) {
          
            maxHeap.offer(new int[] {nums[i], i});
          
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
          
            result[Index++] = maxHeap.peek()[0];
        }
      
        return result;
    }
}
