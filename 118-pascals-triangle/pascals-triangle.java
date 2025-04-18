class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 0));
            row.set(0, 1);
            row.set(i, 1);

            for (int j = 1; j < i; j++) {
                int val = dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j);
                row.set(j, val);
            }

            dp.add(row);
        }

        return dp;
    }
}
