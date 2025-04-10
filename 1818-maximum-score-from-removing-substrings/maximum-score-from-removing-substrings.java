import java.util.Stack;

public class Solution {
    private int remove(StringBuilder s, String str, int points) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == str.charAt(0) && c == str.charAt(1)) {
                stack.pop();
                res += points;
            } else {
                stack.push(c);
            }
        }

        s.setLength(0); 
        for (char c : stack) {
            s.append(c);
        }

        return res;
    }

    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        String a = "ab", b = "ba";

        if (x < y) {
            String temp = a;
            a = b;
            b = temp;
            int tmp = x;
            x = y;
            y = tmp;
        }

        int gain1 = remove(sb, a, x);
        int gain2 = remove(sb, b, y);
        return gain1 + gain2;
    }
}
