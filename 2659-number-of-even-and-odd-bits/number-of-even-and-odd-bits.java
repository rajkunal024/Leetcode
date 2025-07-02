class Solution {
    public int[] evenOddBit(int n) {
        int odd=0;
        int even=0;
        String binary = Integer.toBinaryString(n);
        for(int i=0; i<binary.length(); i++)
        {
            if (binary.charAt(binary.length() - 1 - i) == '1')
            {
                if(i%2==0) even++;
                else odd++;
            }
        }
        int[] ans = {even, odd};
        return ans;
    }
}