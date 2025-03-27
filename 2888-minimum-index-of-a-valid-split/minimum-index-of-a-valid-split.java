import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = findDominantElement(nums);
        int leftCount = 0;
        int rightCount = 0;

        for (int num : nums) {
            if (num == dominant) {
                rightCount++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
                rightCount--;
            }
            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;
    }

    private int findDominantElement(List<Integer> nums) {
        int candidate = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
