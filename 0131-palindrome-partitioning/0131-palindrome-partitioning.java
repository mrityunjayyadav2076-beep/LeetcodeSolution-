class Solution 
{
    private int stringLength;
    private String inputString;
    private boolean[][] isPalindrome;
    private List<String> currentPartition = new ArrayList<>();
    private List<List<String>> allPartitions = new ArrayList<>();
    public List<List<String>> partition(String s) 
    {
        stringLength = s.length();
        inputString = s;
        isPalindrome = new boolean[stringLength][stringLength];

        for (int i = 0; i < stringLength; ++i) 
        {
            Arrays.fill(isPalindrome[i], true);
        }
        for (int startIndex = stringLength - 1; startIndex >= 0; --startIndex) 
        {
            for (int endIndex = startIndex + 1; endIndex < stringLength; ++endIndex) 
            {
         
                isPalindrome[startIndex][endIndex] = 
                    s.charAt(startIndex) == s.charAt(endIndex) && 
                    isPalindrome[startIndex + 1][endIndex - 1];
            }
        }
        findPartitions(0);
        return allPartitions;
    }

    private void findPartitions(int startIndex) 
    
    {

        if (startIndex == inputString.length()) 
        {
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }
   
        for (int endIndex = startIndex; endIndex < stringLength; ++endIndex) 
        {

            if (isPalindrome[startIndex][endIndex]) 
            {
  
                currentPartition.add(inputString.substring(startIndex, endIndex + 1));
              
                
                findPartitions(endIndex + 1);
              
               
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
}