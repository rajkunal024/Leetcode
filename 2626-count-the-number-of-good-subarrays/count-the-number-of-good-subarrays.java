class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Long> freq = new HashMap<>();
        int left = 0;
        long count = 0;
        long totalPairs = 0;

        for (int right = 0; right < nums.length; right++) {
            long currentCount = freq.getOrDefault(nums[right], 0L);
            totalPairs += currentCount;
            freq.put(nums[right], currentCount + 1);

            while (totalPairs >= k) {
                count += nums.length - right;

                long leftCount = freq.get(nums[left]);
                totalPairs -= (leftCount - 1);
                if (leftCount == 1)
                    freq.remove(nums[left]);
                else
                    freq.put(nums[left], leftCount - 1);
                left++;
            }
        }

        return count;
    }
}
