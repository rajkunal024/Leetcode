class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;

        boolean sign = (dividend < 0) == (divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += (1L << count);
            n -= (d << count);
        }

        if (ans >= (1L << 31)) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return (int)(sign ? ans : -ans);
    }
}
