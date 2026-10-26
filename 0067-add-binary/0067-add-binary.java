class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            int digitA = (indexA >= 0) ? a.charAt(indexA) - '0' : 0;
            int digitB = (indexB >= 0) ? b.charAt(indexB) - '0' : 0;
            int sum = digitA + digitB + carry;
          
            result.append(sum % 2);
          
            carry = sum / 2;
            indexA--;
            indexB--;
        }
      
        return result.reverse().toString();
    }
}
