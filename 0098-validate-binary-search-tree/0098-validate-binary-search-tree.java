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
    
    private TreeNode previousNode;

    public boolean isValidBST(TreeNode root) {
        return inOrderTraversal(root);
    }

    private boolean inOrderTraversal(TreeNode currentNode) {
    
        if (currentNode == null) {
            return true;
        }
      
        if (!inOrderTraversal(currentNode.left)) {
            return false;
        }
      
        if (previousNode != null && previousNode.val >= currentNode.val) {
            return false;
        }
      
        previousNode = currentNode;
      
        return inOrderTraversal(currentNode.right);
    }
}
