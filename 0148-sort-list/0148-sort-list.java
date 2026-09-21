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
    public ListNode sortList(ListNode head) 
    {
        if (head == null || head.next == null) 
        {
            return head;
        }
      
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
      
        while (fastPointer != null && fastPointer.next != null) 
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
      
        ListNode firstHalf = head;
        ListNode secondHalf = slowPointer.next;
        slowPointer.next = null;
      
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
      
        ListNode dummyHead = new ListNode();  
        ListNode currentTail = dummyHead;
      
        while (firstHalf != null && secondHalf != null) 
        {
            if (firstHalf.val <= secondHalf.val) 
            {
                currentTail.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                currentTail.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            currentTail = currentTail.next;
        }
      
        currentTail.next = (firstHalf != null) ? firstHalf : secondHalf;
      
        return dummyHead.next;
    }
}
