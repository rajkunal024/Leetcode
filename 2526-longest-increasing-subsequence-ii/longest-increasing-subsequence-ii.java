class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        SegmentTree segTree = new SegmentTree(maxVal + 1);
        int maxLength = 0;

        for (int num : nums) {
            int bestPrevLIS = segTree.query(Math.max(0, num - k), num - 1);
            int newLIS = bestPrevLIS + 1;
            segTree.update(num, newLIS);
            maxLength = Math.max(maxLength, newLIS);
        }

        return maxLength;
    }
}

class SegmentTree {
    private int[] tree;
    private int size;

    public SegmentTree(int n) {
        size = n;
        tree = new int[4 * n];
    }

    public void update(int index, int value) {
        update(1, 0, size - 1, index, value);
    }

    private void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = Math.max(tree[node], value);
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    public int query(int left, int right) {
        if (left > right) return 0;
        return query(1, 0, size - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 0;
        if (start >= left && end <= right) return tree[node];
        int mid = (start + end) / 2;
        int leftMax = query(2 * node, start, mid, left, right);
        int rightMax = query(2 * node + 1, mid + 1, end, left, right);
        return Math.max(leftMax, rightMax);
    }
}
