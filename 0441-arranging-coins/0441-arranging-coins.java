class Solution {
    public int arrangeCoins(int n) {
       long X = 0;
       long Y= n;
       while(X <= Y){
        long mid = X +(Y -X)/2;
        long currentCoins = mid *(mid +1)/2;

        if(currentCoins ==n){
            return (int) mid;
        }
        else if (currentCoins <n){
            X = mid +1;
        }
        else {
            Y = mid -1;
        }
       }
       return (int) Y;
    }
}