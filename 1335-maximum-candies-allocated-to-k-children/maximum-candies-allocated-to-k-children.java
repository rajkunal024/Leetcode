class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 0;
        for (int candy : candies) right = Math.max(right, candy); 
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) { 
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean canDistribute(int[] candies, long k, int perChild) {
        long count = 0;
        for (int candy : candies) {
            count += candy / perChild;
            if (count >= k) return true;
        }
        return false;
    }
}
