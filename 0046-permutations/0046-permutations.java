class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> currentPermutation = new ArrayList<>();
 
    private boolean[] visited;

    private int[] numbers;

    public List<List<Integer>> permute(int[] nums) {
        this.numbers = nums;
        this.visited = new boolean[nums.length];
        backtrack(0);
        return result;
    }

    private void backtrack(int depth) {
 
        if (depth == numbers.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {

            if (!visited[i]) {

                visited[i] = true;
 
                currentPermutation.add(numbers[i]);
    
                backtrack(depth + 1);
 
                currentPermutation.remove(currentPermutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
