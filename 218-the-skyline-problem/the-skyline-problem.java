import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]});
            points.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; 
            return a[1] - b[1]; 
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        
        int prevHeight = 0;
        List<List<Integer>> skyline = new ArrayList<>();
        
        for (int[] p : points) {
            int x = p[0], height = p[1];
            
            if (height < 0) { 
                maxHeap.add(-height);
            } else { 
                maxHeap.remove(height); 
            }
            
            int currHeight = maxHeap.peek();
            
            if (currHeight != prevHeight) {
                skyline.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }
        
        return skyline;
    }
}
