class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        Map< Integer, Integer > map= new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> intersection = new ArrayList<>();

        for(int num :nums2){
            if(map.get(num) != null
            && map.get(num)>0){
                intersection.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        int[] result = new int[intersection.size()];
        for(int i=0; i<intersection.size(); i++){
            result[i] = intersection.get(i);
        }
        return result;
    }
}