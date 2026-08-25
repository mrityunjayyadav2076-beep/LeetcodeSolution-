class Solution {
    public int splitArray(int[] nums, int k) {
        int A =0;
        int B =0;

        for(int num: nums){
            A = Math.max(A, num);
            B+= num;
        }
        int ans = B;
        while(A<=B){
            int mid = A+(B-A)/2;

            if(canSplit(nums, k,mid)){
                ans =mid;
                B = mid-1;
            }
            else{
                A = mid+1;
            }
        }
        return ans;
    }
        private boolean canSplit(int[] nums, int k, int maxTargetSum){
            int subarrayCount =1;
            int currentSum = 0;

            for(int num : nums){
                if(currentSum +num >maxTargetSum){
                    subarrayCount++;
                    currentSum = num;

                    if(subarrayCount>k){
                        return false;
                    }
                }
                else{
                    currentSum +=num;
                }
            }
            return true;
        }
    }