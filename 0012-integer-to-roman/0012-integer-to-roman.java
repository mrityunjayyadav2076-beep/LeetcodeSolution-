class Solution {
    public String intToRoman(int num) {
        String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] val = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder res = new StringBuilder();
        int idx = val.length - 1;
        while(num > 0 && idx >= 0){
            if(num < val[idx]) idx -= 1;
            else{
                num -= val[idx];
                res.append(sym[idx]);
            }
        }
        return res.toString();
    }
}