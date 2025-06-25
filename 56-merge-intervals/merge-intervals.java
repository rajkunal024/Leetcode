class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for(int i=0; i<intervals.length; i++)
        {
            int[] curr = intervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                merged.add(curr);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}