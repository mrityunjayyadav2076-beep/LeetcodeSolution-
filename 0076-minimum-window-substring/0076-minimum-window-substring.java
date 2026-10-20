class Solution {
    public String minWindow(String s, String t) {
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];
      
        for (char ch : t.toCharArray()) {
            targetFreq[ch]++;
        }
      
        int sL = s.length();
        int tL = t.length();
      
        int Start = -1;  
        int Len = sL + 1;  
        int Count = 0;  
      
        int left = 0;
        for (int i = 0; i < sL; i++) {
            
            char rightChar = s.charAt(i);
            windowFreq[rightChar]++;
          
            if (windowFreq[rightChar] <= targetFreq[rightChar]) {
                Count++;
            }
          
            while (Count == tL) {
                if (i - left + 1 < Len) {
                    Len = i - left + 1;
                    Start = left;
                }
              
                char leftChar = s.charAt(left);
              
                if (windowFreq[leftChar] <= targetFreq[leftChar]) {
                    Count--;
                }
              
                windowFreq[leftChar]--;
                left++;
            }
        }
      
        return Start < 0 ? "" : s.substring(Start, Start + Len);
    }
}
