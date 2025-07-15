class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        while(left <= right) {
            int set = counBit(left);
            if(prime(set)) count++;
            left++;
        }
        return count;
    }

    public int counBit(int n) {
        int count =0;
        while(n > 0) {
            if((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public boolean prime(int n) {
        if(n <= 1) return false;
        int count=0;

        for(int i=2;i<=Math.sqrt(n);i++){
            if((n%i)==0){
                return false;
            }
        }
        return true;
    }
}