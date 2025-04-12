import java.util.*;

public class Solution {
    public long countGoodIntegers(int n, int k) {
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long result = 0;
        Set<String> seen = new HashSet<>();
        int halfLength = (n + 1) / 2;
        int start = (int) Math.pow(10, halfLength - 1);
        int end = (int) Math.pow(10, halfLength);

        for (int num = start; num < end; num++) {
            String firstHalf = String.valueOf(num);
            String secondHalf = new StringBuilder(firstHalf).reverse().toString();
            String palindrome = firstHalf + secondHalf.substring(n % 2);
            long palNum = Long.parseLong(palindrome);
            if (palNum % k != 0) continue;

            char[] chars = palindrome.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (seen.contains(sorted)) continue;
            seen.add(sorted);

            int[] count = new int[10];
            for (char c : palindrome.toCharArray()) {
                count[c - '0']++;
            }

            long permutations = factorial[n];
            for (int c : count) {
                if (c > 1) {
                    permutations /= factorial[c];
                }
            }

            if (count[0] > 0) {
                count[0]--;
                long invalid = factorial[n - 1];
                for (int c : count) {
                    if (c > 1) {
                        invalid /= factorial[c];
                    }
                }
                permutations -= invalid;
                count[0]++;
            }

            result += permutations;
        }

        return result;
    }
}
