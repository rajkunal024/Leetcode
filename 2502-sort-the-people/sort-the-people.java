import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        int n = heights.length;
        String[] result = new String[n];

        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            result[j] = map.get(heights[i]);
        }

        return result;
    }
}
