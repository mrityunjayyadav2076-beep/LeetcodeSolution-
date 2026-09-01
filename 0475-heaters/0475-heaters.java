class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int midRadius = 0;

        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0){
                index = -(index + 1);
            }
            int distRight = (index < heaters.length)? heaters[index]-house: Integer.MAX_VALUE;
            int distLeft = (index > 0)? house - heaters[index-1]:Integer.MAX_VALUE;
            int closestHeaterDist = Math.min(distLeft, distRight);
            midRadius = Math.max(midRadius, closestHeaterDist);
        }
        return midRadius;
    }
}