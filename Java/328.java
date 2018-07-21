/**
The point is to find the best way to check if pointer_odd and pointer_even reach the end of list.
pointer_even is sufficient to check the 2 possible cases
1) the list ends with odd number, where pe == null
2) the list ends with even number, where pe != null
update both odd chain and even chain at the same time, 
and use a pointer to point to head of even list so we can append it to the odd chain.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode po = head, pe = head.next;
        ListNode headEven = head.next;
        
        while(pe != null && pe.next != null) {
            
            po.next = po.next.next;
            pe.next = pe.next.next;
            po = po.next;
            pe = pe.next;
        }
        po.next = headEven;
        
        return head;
    }
}
