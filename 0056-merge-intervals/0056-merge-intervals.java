class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) 
        {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd < nextStart) 
            {
                mergedIntervals.add(new int[] {currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            } else 
            {
                currentEnd = Math.max(currentEnd, nextEnd);
            }
        }

        mergedIntervals.add(new int[] {currentStart, currentEnd});

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
