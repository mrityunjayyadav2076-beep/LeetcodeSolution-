import java.math.BigInteger;
class Solution {
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        BigInteger target = BigInteger.valueOf(nVal);

        for (int m = 60; m >= 2; m--) {

            long left = 2;
            long right = (long) Math.pow(nVal, 1.0 / m) + 1;
            
            while (left <= right) {
                long mid = left + (right - left) / 2;
                BigInteger base = BigInteger.valueOf(mid);
                BigInteger sum = BigInteger.ZERO;
                
                for (int i = 0; i <= m; i++) {
                    sum = sum.multiply(base).add(BigInteger.ONE);
                }
                
                int cmp = sum.compareTo(target);
                if (cmp == 0) {
                    return String.valueOf(mid); 
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return String.valueOf(nVal - 1);
    }
}