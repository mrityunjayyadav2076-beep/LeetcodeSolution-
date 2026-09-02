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
    public ListNode swapPairs(ListNode head) {
       if(head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(), first, second, prev=dummy;
        prev.next = head;
        while(prev.next != null && prev.next.next!=null){
            first = prev.next;
            second = first.next;
            prev.next = second;
            first.next = second.next;
            prev = second.next = first;
        }
        return dummy.next;
    }
} 