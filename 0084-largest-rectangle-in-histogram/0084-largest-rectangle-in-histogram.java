class Solution {
    public int largestRectangleArea(int[] heights) 
    {
        int maxArea = 0;
        int n = heights.length;
      
        Deque<Integer> stack = new ArrayDeque<>();
      
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) 
        {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
            {
                right[stack.pop()] = i;
            }
          
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
      
        for (int i = 0; i < n; i++) 
        {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
      
        return maxArea;
    }
}
