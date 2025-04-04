class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++)
        {
            boolean[] rowcheck = new boolean[n+1];
            boolean[] colcheck = new boolean[n+1];

            for(int j=0; j<n; j++)
            {
                int rowval = matrix[i][j];
                int colval = matrix[j][i];
                if(rowval < 1 || rowval > n || rowcheck[rowval]) return false;
                rowcheck[rowval]= true;

                if(colval < 1 || colval > n || colcheck[colval]) return false;
                colcheck[colval] = true;
            }
        }
        return true;
    }
}