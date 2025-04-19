class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        int[][] combined = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = heights[i];
            combined[i][1] = i;
        }

        Arrays.sort(combined, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[combined[i][1]];
        }

        return result;
    }
}
