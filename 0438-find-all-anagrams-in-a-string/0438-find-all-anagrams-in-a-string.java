class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();

        if (sLength < pLength) {
            return result;
        }
      
        int[] patternFreq = new int[26];
        for (int i = 0; i < pLength; i++) {
            patternFreq[p.charAt(i) - 'a']++;
        }
    
        int[] windowFreq = new int[26];
        for (int i = 0; i < pLength - 1; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }
      
        for (int i = pLength - 1; i < sLength; i++) {
            windowFreq[s.charAt(i) - 'a']++;
          
            if (Arrays.equals(patternFreq, windowFreq)) {
                result.add(i - pLength + 1);
            }
          
            windowFreq[s.charAt(i - pLength + 1) - 'a']--;
        }
      
        return result;
    }
}
