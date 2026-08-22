class Solution {
    public boolean isPerfectSquare(int nums) {
       if(nums <1){
        return false;
       } 
       long A = 1;
       long B = nums;
       while(A<=B){
        long mid= A+(B-A)/2;
        long square = mid*mid;

        if(square == nums){
            return true;
        }
        else if(square>nums){
            B=mid-1;
        }
        else{
            A= mid+1;
        }
       }
       return false;
    }
}