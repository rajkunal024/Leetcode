class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        for (int[] row : image) {
            int left = 0, right = cols - 1;
            while (left <= right) {
                int temp = row[left] ^ 1;
                row[left] = row[right] ^ 1;
                row[right] = temp;
                
                left++;
                right--;
            }
        }
        return image;
    }
}