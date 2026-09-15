class Solution {
    public int longestConsecutive(int[] nums) {
    
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) 
        {
            numSet.add(num);
        }

        int maxLength = 0;
       
        Map<Integer, Integer> sequenceLengthMap = new HashMap<>();

        for (int num : nums) 
        {
            
            int currentNum = num;

            while (numSet.contains(currentNum)) 
            {
                numSet.remove(currentNum);
                currentNum++;
            }

            int sequenceLength = (currentNum - num) + sequenceLengthMap.getOrDefault(currentNum, 0);
            sequenceLengthMap.put(num, sequenceLength);

            maxLength = Math.max(maxLength, sequenceLengthMap.get(num));
        }

        return maxLength;
    }
}
