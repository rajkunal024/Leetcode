/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        rightview(root, view, 0);
        return view;
    }

    public void rightview(TreeNode curr, List<Integer> view, int depth) {
        if(curr == null) return;

        if(depth == view.size()) view.add(curr.val);

        rightview(curr.right, view, depth+1);
        rightview(curr.left, view, depth+1);
    }
}