class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = true;
        if(dividend < 0 && divisor > 0) sign = false;
        if(dividend >= 0 && divisor < 0) sign = false;
        if(dividend < 0 && divisor < 0) sign = true;
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int ans=0;
        // if(dividend >= Math.pow(2, 31) && sign == true && d == 1) return Integer.MAX_VALUE;
        // if(dividend <= Math.pow(-2, 31) && sign == false && d == 1) return Integer.MIN_VALUE;
        // if(dividend <= Math.pow(-2, 31) && sign == true && d == 1) return Integer.MAX_VALUE;
        // if(dividend >= Math.pow(2, 31) && sign == false && d == 1) return Integer.MIN_VALUE;
        while(n>=d)
        {
            int count =0;
            while(n >= (d << ( count + 1)))
            {
                count++;
            }
            ans += (1 << count);
            n =n -(d<<count);
        }
        return sign ? ans : (-1*ans);
    }
}