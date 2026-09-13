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
    private int[] preorderArray;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int totalNodes = preorder.length;
        this.preorderArray = preorder;

        for (int i = 0; i < totalNodes; ++i) {
            inorderIndexMap.put(inorder[i], i);
        }
      
        return dfs(0, 0, totalNodes);
    }
    private TreeNode dfs(int preorderStartIndex, int inorderStartIndex, int subtreeSize) {

        if (subtreeSize <= 0) {
            return null;
        }
      
        int rootValue = preorderArray[preorderStartIndex];
      
        int rootInorderIndex = inorderIndexMap.get(rootValue);
      
        int leftSubtreeSize = rootInorderIndex - inorderStartIndex;
      
        TreeNode leftChild = dfs(preorderStartIndex + 1, inorderStartIndex, leftSubtreeSize);
      
        TreeNode rightChild = dfs(preorderStartIndex + 1 + leftSubtreeSize, 
                                 rootInorderIndex + 1, 
                                 subtreeSize - 1 - leftSubtreeSize);
      
        return new TreeNode(rootValue, leftChild, rightChild);
    }
}
