/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        Set<ListNode> visitedNodes = new HashSet<>();

        ListNode currentNode = head;
        while (currentNode != null) 
        {
            if (!visitedNodes.add(currentNode)) 
            {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }
}
