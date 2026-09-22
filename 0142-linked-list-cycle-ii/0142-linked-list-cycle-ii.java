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
    public ListNode detectCycle(ListNode head) 
    {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
      
        while (fastPointer != null && fastPointer.next != null) 
        {
            slowPointer = slowPointer.next;         
            fastPointer = fastPointer.next.next;    
          
            if (slowPointer == fastPointer) 
            {
                ListNode startPointer = head;
              
                while (startPointer != slowPointer) 
                {
                    startPointer = startPointer.next;
                    slowPointer = slowPointer.next;
                }
              
                return startPointer;
            }
        }
      
        return null;
    }
}
