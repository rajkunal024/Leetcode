import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] freq = new int[1001];
        int rows = nums.length;

        for (int[] row : nums) {
            for (int num : row) {
                freq[num]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == rows) {
                result.add(i);
            }
        }
        return result;
    }
}
