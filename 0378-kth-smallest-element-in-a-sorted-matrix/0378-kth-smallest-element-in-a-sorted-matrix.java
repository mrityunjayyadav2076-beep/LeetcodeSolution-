class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int n= matrix.length;
       int low = matrix[0][0];
       int high = matrix[n-1][n-1];
       int ans = low;

       while(low <= high){
        int mid = low+(high -low)/2;

        if(countLessEqual(matrix, mid) >=k ){
            ans= mid;
            high = mid-1;
        }
        else {
            low= mid + 1;
        }
       } 
       return ans;
    }
    private int countLessEqual(int[][] matrix, int mid){
        int n=matrix.length;
        int count =0;
        int row = 0;
        int col = n-1;

        while(row <n && col >=0){
            if(matrix[row][col]<=mid){
               count+= (col +1);
               row++; 
            }
            else {
            col--;
            }
        }
        return count;
    }
}