class Solution 
{
    public String decodeString(String s) 
    {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();
      
        int cC = 0;
        String cS = "";
      
        for (char ch : s.toCharArray()) 
        {
            if (Character.isDigit(ch)) 
            {
                cC = cC * 10 + (ch - '0');
            } else if (ch == '[') 
            {
                countStack.push(cC);
                stringStack.push(cS);
                cC = 0;
                cS = "";
            } else if (ch == ']') 
            {
                int repeatTimes = countStack.pop();
                StringBuilder repeatedString = new StringBuilder();
              
                for (int i = 0; i < repeatTimes; i++) 
                {
                    repeatedString.append(cS);
                }
              
                cS = stringStack.pop() + repeatedString.toString();
            } else {
                cS += ch;
            }
        }
      
        return cS;
    }
}
