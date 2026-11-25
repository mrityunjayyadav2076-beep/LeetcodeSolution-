class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        int numberOfStrings = strs.length;

        for (int charIndex = 0; charIndex < strs[0].length(); charIndex++) 
        {
            for (int stringIndex = 1; stringIndex < numberOfStrings; stringIndex++) 
            {
                if (strs[stringIndex].length() <= charIndex ||
                    strs[stringIndex].charAt(charIndex) != strs[0].charAt(charIndex)) 
                    {
                    return strs[0].substring(0, charIndex);
                }
            }
        }
        return strs[0];
    }
}
