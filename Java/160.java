/**
1. Compute length of both lists
2. use 1 pointer on each list, ensure they have the same distance from end of list, 
   by moving forward the pointer on the longer list by times of difference in their lengths.
3. move both pointers at the same time, and return the list node if they points to the same node,
   otherwise return null if they reached end of lists.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p = null;
        for(p = headA; p!=null; p=p.next){
            lenA++;
        }
        for(p = headB; p!=null; p=p.next){
            lenB++;
        }
        
        ListNode pa = headA, pb = headB;
        if(lenA > lenB){
            for(int diff = lenA - lenB; diff > 0; diff--){
                pa = pa.next;
            }
        } else {
            for(int diff = lenB - lenA; diff > 0; diff--){
                pb = pb.next;
            }
        }
        
        while(pa!=null && pb!=null){
            if(pa == pb) return pa;
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
