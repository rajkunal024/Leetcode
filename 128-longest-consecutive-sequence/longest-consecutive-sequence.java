class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count=1;
        int longest=1;
        if(nums.length<1) return 0;
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i]==nums[i+1]) continue;
            else if((nums[i]+1)== nums[i+1])
            {
                count++;
            }
            else count =1;
            longest=Math.max(count,longest);
        }
        return longest;
    }
}