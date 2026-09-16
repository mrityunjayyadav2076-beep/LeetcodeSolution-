class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
      
        prefixSumCount.put(0, 1);
      
        int count = 0;           
        int currentSum = 0;      
      
        for (int num : nums) {

            currentSum += num;
          
            count += prefixSumCount.getOrDefault(currentSum - k, 0);
          
            prefixSumCount.merge(currentSum, 1, Integer::sum);
        }
      
        return count;
    }
}
