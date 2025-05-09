class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstNonNegative(nums);
        int posCount = nums.length - findFirstPositive(nums);
        return Math.max(negCount, posCount);
    }

    private int findFirstNonNegative(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
