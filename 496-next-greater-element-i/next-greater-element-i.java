class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int nextGreater = -1;
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (nums2[j] == nums1[i]) {
                    found = true;
                }
                if (found && nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            result[i] = nextGreater;
        }

        return result;
    }
}