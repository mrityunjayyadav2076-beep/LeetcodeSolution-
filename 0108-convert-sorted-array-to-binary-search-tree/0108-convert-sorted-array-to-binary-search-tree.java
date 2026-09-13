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

    private int[] nums;
  
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
    
        return buildBST(0, nums.length - 1);
    }
  
    private TreeNode buildBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) >> 1;
        return new TreeNode(
            nums[middle], 
            buildBST(left, middle - 1), 
            buildBST(middle + 1, right)
        );
    }
}
