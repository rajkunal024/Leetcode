class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (arr[end] == ' ' || end == n - 1) {
                int right = (arr[end] == ' ') ? end - 1 : end;
                reverse(arr, start, right);
                start = end + 1;
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
