class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
                List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return ans;

        int m = words.length;
        int w = words[0].length();
        int needLen = m * w;
        if (s.length() < needLen) return ans;

        Map<String, Integer> id = new HashMap<>();
        int nextId = 0;
        for (String word : words) {
            if (!id.containsKey(word)) {
                id.put(word, nextId++);
            }
        }
        int k = nextId;

        int[] need = new int[k];
        for (String word : words) {
            need[id.get(word)]++;
        }

        for (int offset = 0; offset < w; offset++) {
            int left = offset;
            int used = 0;
            int[] window = new int[k];

            for (int right = offset; right + w <= s.length(); right += w) {
                String piece = s.substring(right, right + w);
                Integer pid = id.get(piece);

                if (pid == null) {
                    Arrays.fill(window, 0);
                    used = 0;
                    left = right + w;
                    continue;
                }

                window[pid]++;
                used++;

                while (window[pid] > need[pid]) {
                    String drop = s.substring(left, left + w);
                    Integer did = id.get(drop);
                    window[did]--;
                    left += w;
                    used--;
                }

                if (used == m) {
                    ans.add(left);
                    String drop = s.substring(left, left + w);
                    Integer did = id.get(drop);
                    window[did]--;
                    left += w;
                    used--;
                }
            }
        }

        return ans;
    }
}
