import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsetCount = 1 << n;
        List<List<Integer>> outer = new ArrayList<>();

        for (int i = 0; i < subsetCount; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    inner.add(nums[j]);
                }
            }
            outer.add(inner);
        }

        return outer;
    }
}
