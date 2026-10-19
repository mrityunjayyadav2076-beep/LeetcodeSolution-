class Solution {
    private Integer[] memo;
    private int[] houses;

    public int rob(int[] nums) {
        this.houses = nums;
        this.memo = new Integer[nums.length];
        return calculateMaxRobbery(0);
    }
    private int calculateMaxRobbery(int houseIndex) {
        if (houseIndex >= houses.length) {
            return 0;
        }
      
        if (memo[houseIndex] == null) {
            int robCurrentHouse = houses[houseIndex] + calculateMaxRobbery(houseIndex + 2);
            int skipCurrentHouse = calculateMaxRobbery(houseIndex + 1);
          
            memo[houseIndex] = Math.max(robCurrentHouse, skipCurrentHouse);
        }
      
        return memo[houseIndex];
    }
}
