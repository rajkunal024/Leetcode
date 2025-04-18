class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        for(int i=0; i<numRows; i++)
        {
            List<Integer> dp1 = new ArrayList<>();
            dp1.add(1);
            for (int j = 1; j < i; j++) {
                int val = dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j);
                dp1.add(val);
            }

            if(i>0)
            dp1.add(1);

            dp.add(dp1);

        }
        return dp;
    }
}