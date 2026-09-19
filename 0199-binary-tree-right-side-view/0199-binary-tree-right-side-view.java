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
class Solution 
{
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();
      
        if (root == null) 
        {
            return result;
        }
      
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
      
        while (!queue.isEmpty()) 
        {
            result.add(queue.peekFirst().val);
          
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) 
            {
                TreeNode currentNode = queue.poll();
              
                if (currentNode.right != null) 
                {
                    queue.offer(currentNode.right);
                }
              
                if (currentNode.left != null) 
                {
                    queue.offer(currentNode.left);
                }
            }
        }
      
        return result;
    }
}
