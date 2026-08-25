class Solution {
    public int[] findRightInterval(int[][] intervals) {
       int n= intervals.length;
       int[] result = new int[n];

       int [][] startWithIndex = new int[n][2];
       for(int i=0; i<n; i++){
        startWithIndex[i][0] = intervals[i][0];
        startWithIndex[i][1] = i;
       } 
       Arrays.sort(startWithIndex, (a, b)-> Integer.compare(a[0], b[0]));
       for(int i=0; i<n; i++){
        int targetEnd = intervals[i][1];
        int rightIndex = binarySearch(startWithIndex, targetEnd);
        result[i] = rightIndex;
       }
       return result;
    }
    private int binarySearch(int[][] startWithIndex, int target){
        int A =0;
        int B = startWithIndex.length-1;
        int ans = -1;

        while(A <= B){
            int mid = A+(B-A)/2;
            if(startWithIndex[mid][0] >= target){
                ans = startWithIndex[mid][1];
                B = mid-1;
            }
            else {
                A = mid+1;
            }
        }
        return ans;
    }
}