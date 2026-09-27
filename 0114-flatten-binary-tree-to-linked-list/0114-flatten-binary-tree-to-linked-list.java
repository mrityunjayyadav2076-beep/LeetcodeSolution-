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
    public void flatten(TreeNode root) {
        TreeNode currentNode = root;
      
        while (currentNode != null) {
            if (currentNode.left != null) {
        
                TreeNode rightmostInLeftSubtree = currentNode.left;
                while (rightmostInLeftSubtree.right != null) {
                    rightmostInLeftSubtree = rightmostInLeftSubtree.right;
                }
              
                rightmostInLeftSubtree.right = currentNode.right;
              
                currentNode.right = currentNode.left;
                currentNode.left = null;
            }
          
            currentNode = currentNode.right;
        }
    }
}
