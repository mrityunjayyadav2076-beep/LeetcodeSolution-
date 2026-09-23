/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewMap = new HashMap<>();
      
        Node dummyHead = new Node(0);
        Node currentTail = dummyHead;
      
        for (Node currentOriginal = head; currentOriginal != null; currentOriginal = currentOriginal.next) {
            Node newNode = new Node(currentOriginal.val);
          
            currentTail.next = newNode;
            currentTail = newNode;
          
            oldToNewMap.put(currentOriginal, newNode);
        }
      
        for (Node currentOriginal = head; currentOriginal != null; currentOriginal = currentOriginal.next) {
            Node copiedNode = oldToNewMap.get(currentOriginal);
          
            copiedNode.random = (currentOriginal.random == null) ? null : oldToNewMap.get(currentOriginal.random);
        }
      
        return dummyHead.next;
    }
}
