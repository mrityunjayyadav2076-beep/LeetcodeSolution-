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
    private List<String> allPaths = new ArrayList<>();
  
    private List<String> currentPath = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        depthFirstSearch(root);
        return allPaths;
    }

    private void depthFirstSearch(TreeNode node) {
        if (node == null) {
            return;
        }
      
        currentPath.add(String.valueOf(node.val));
      
        if (node.left == null && node.right == null) {
            allPaths.add(String.join("->", currentPath));
        } else {
            depthFirstSearch(node.left);
            depthFirstSearch(node.right);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
