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
        int[] freq = new int[nums.length + 1]; // index 1 to n
        for (int num : nums) {
            freq[num]++;
        }

        int[] result = new int[2]; // [duplicate, missing]
        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 0) result[1] = i;     // missing
            else if (freq[i] == 2) result[0] = i; // duplicate
        }

        return result;
    }
}
