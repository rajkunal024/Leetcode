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
import java.util.HashMap;

class Solution {
    private int postIndex; 
    private HashMap<Integer, Integer> inorderMap = new HashMap<>(); 

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; 

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int inIndex = inorderMap.get(rootValue);

        root.right = constructTree(postorder, inIndex + 1, inEnd);
        root.left = constructTree(postorder, inStart, inIndex - 1);

        return root;
    }
}
