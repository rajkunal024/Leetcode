class Solution {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        while (n != 0) {
            if ((n & 1) == 1) ans[0]++;
            n >>= 1;
            if ((n & 1) == 1) ans[1]++;
            n >>= 1;
        }
        return ans;
    }
}