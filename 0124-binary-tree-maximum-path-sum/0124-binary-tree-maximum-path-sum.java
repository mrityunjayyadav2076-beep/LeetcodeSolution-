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
    private int maxSum = -1001;

    public int maxPathSum(TreeNode root) {
        calculateMaxGain(root);
        return maxSum;
    }
    private int calculateMaxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(0, calculateMaxGain(node.left));
        int rightGain = Math.max(0, calculateMaxGain(node.right));
        int currentMaxPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentMaxPath);
        return node.val + Math.max(leftGain, rightGain);
    }
} 