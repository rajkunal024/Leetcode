import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10]; // Count occurrences of each digit
        
        for (int digit : digits) freq[digit]++;

        ArrayList<Integer> result = new ArrayList<>();
        
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            if (freq[d1] > 0 && freq[d2] > 0 && freq[d3] > 0) {
                freq[d1]--; freq[d2]--; freq[d3]--;
                if (freq[d1] >= 0 && freq[d2] >= 0 && freq[d3] >= 0) {
                    result.add(num);
                }
                freq[d1]++; freq[d2]++; freq[d3]++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
