/**
Use 2 pointers to traverse the list, slow moves 1 step whlie fast moves 2 steps per turn.
If there is a cycle then the 2 pointers will eventually point to the same node.
If fast pointer becomes null then there's no cycle.

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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while(fast != null){
            if(fast == slow) return true;
            fast = fast.next;
            if(fast == slow) return true;
            if(fast == null) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}
