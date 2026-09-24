/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
      
        ListNode previousGroupTail = dummy;
      
        while (previousGroupTail != null) {
            ListNode currentNode = previousGroupTail;
            for (int i = 0; i < k; i++) {
                currentNode = currentNode.next;
                if (currentNode == null) {
                    return dummy.next;
                }
            }
          
            ListNode groupStart = previousGroupTail.next;  
            ListNode nextGroupStart = currentNode.next;     
          
            currentNode.next = null;
          
            previousGroupTail.next = reverse(groupStart);
          
            groupStart.next = nextGroupStart;
          
            previousGroupTail = groupStart;
        }
      
        return dummy.next;
    }
  
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode current = head;
      
        while (current != null) {
            ListNode nextNode = current.next;  
            current.next = dummy.next;          
            dummy.next = current;                
            current = nextNode;                  
        }
      
        return dummy.next;
    }
}
