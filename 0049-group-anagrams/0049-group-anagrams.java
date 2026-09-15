class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
       
            char[] charArray = str.toCharArray();

            Arrays.sort(charArray);

            String sortedKey = String.valueOf(charArray);

            anagramGroups.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
