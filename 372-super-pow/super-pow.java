class Solution {
    private static final int MOD = 1337;

    private int modPow(int a, int b) {
        int result = 1;
        a %= MOD;
        
        while (b > 0) {
            if (b % 2 == 1) { 
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        int result = 1;
        for (int digit : b) {
            result = (modPow(result, 10) * modPow(a, digit)) % MOD;
        }
        return result;
    }
}
