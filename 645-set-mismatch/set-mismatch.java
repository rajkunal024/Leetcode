// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         Arrays.sort(nums);
//         int[] arr = new int[2];
//         int total=0;
//         int sum=0;
//         for(int i=0; i<nums.length; i++)
//         {
//             total +=i+1;
//             sum +=nums[i];
//         }

//         int sub = total-sum;

//         for(int i=1; i<nums.length; i++){
//             if(nums[i-1]==nums[i])
//             {
//                 arr[0]=nums[i];
//                 arr[1]=nums[i]+sub;
//             }
//         }

//         return arr;

//     }
// }

class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;

        int[] counter = new int[n + 1];
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            ans[1] ^= (i + 1) ^ nums[i];

            if (++counter[nums[i]] == 2) {
                ans[0] = nums[i];
            }
        }

        ans[1] ^= ans[0]; 

        return ans;

    }
}