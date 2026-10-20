class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        int stringLength = s.length();
      
        for (int i = 0; i < stringLength; ++i) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
      
        List<Integer> partitionSizes = new ArrayList<>();
      
        int max = 0;  
        int partition = 0;        
      
        for (int i = 0; i < stringLength; ++i) {
            
            max = Math.max(max, lastOccurrence[s.charAt(i) - 'a']);
          
            if (max == i) {
                partitionSizes.add(i - partition + 1);
                partition = i + 1;
            }
        }
      
        return partitionSizes;
    }
}
