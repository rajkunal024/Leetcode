class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (!isVowel(ch[left])) {
                left++;
            } else if (!isVowel(ch[right])) {
                right--;
            } else {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }

        return String.valueOf(ch);
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
