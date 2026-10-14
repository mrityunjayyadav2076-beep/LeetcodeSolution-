class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {
        maxHeap.offer(num);
      
        minHeap.offer(maxHeap.poll());
      
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian() {
        return minHeap.size() == maxHeap.size() 
            ? (minHeap.peek() + maxHeap.peek()) / 2.0 
            : minHeap.peek();
    }
}
