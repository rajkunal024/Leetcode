class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] mat = new int[n][n];
        int value = 0;
        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = value++;
            }
        }

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            if (command.equals("RIGHT")) {
                col++;
            } else if (command.equals("LEFT")) {
                col--;
            } else if (command.equals("DOWN")) {
                row++;
            } else if (command.equals("UP")) {
                row--;
            }
        }


        return mat[row][col];
    }
}
