class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
      
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
      
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
      
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
          
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
      
        return minHeap.stream()
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
