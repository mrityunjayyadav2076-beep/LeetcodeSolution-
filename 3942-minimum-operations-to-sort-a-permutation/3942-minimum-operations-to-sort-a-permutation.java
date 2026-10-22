import java.util.function.IntPredicate;

class Solution {
    public int minOperations(int[] nums) {
        int length = nums.length;

        int z = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                z = i;
                break;
            }
        }

        final int a = z;

        IntPredicate isNonDecreasing = step -> {
            for (int i = 1; i < length; i++) {
                int p = (a + (i - 1) * step + length) % length;
                int c = (a + i * step + length) % length;

                if (nums[p] > nums[c]) {
                    return false;
                }
            }

            return true;
        };

        int answer = Integer.MAX_VALUE;
        if (isNonDecreasing.test(1)) {
            answer = Math.min(answer, z);
            answer = Math.min(answer, length - z + 2);
        }
        if (isNonDecreasing.test(-1)) {
            answer = Math.min(answer, z + 2);
            answer = Math.min(answer, length - z);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
