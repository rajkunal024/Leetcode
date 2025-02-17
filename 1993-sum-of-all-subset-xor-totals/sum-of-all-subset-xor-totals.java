class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int xorSum) {
        if (index == nums.length) return xorSum;

        int include = dfs(nums, index + 1, xorSum ^ nums[index]);
        
        int exclude = dfs(nums, index + 1, xorSum);
        
        return include + exclude;
    }
}
