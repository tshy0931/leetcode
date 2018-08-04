/**
1. Find the middle point of the list and reverse the first part of the list.
This can be done by traversing the list with 2 pointers at the same time, slow (1 step per turn) and fast (2 steps per turn).
When the fast pointer reaches end of the list, the slow pointer is at the middle of the list.

Two situations can happen:

a) List length is odd, then fast pointer will be at the last node, e.g.
1 -> 2 -> 3 -> 2 -> 1
          |         |
          slow      fast
          
b) List length is even, then fast pointer will be at second last node, e.g.
1 -> 2 -> 3 -> 3 -> 2 -> 1
          |         |
          slow      fast

2. While traversing in step 1. reverse the first half of the list, which can be done by using 3 pointers to locate current node at slow pointer and its previous node and next node. e.g. how the list looks like after traversing.
1 <- 2    3 -> 2 -> 1
     |    |    |    |
     prev slow next fast
 
1 <- 2    3 -> 3 -> 2 -> 1
     |    |    |    |
     prev slow next fast

3. Now traverse from middle to both left and right end of the list, and at each step the value of nodes must equal to be a palindrome. How to find the starting point? it depends on whether the list length is odd or even:

a) if list length is odd,
starting point of left part is the previous node of current slow node.
starting point of right part is the next node of current slow node.
Now it looks like
1 <- 2    3 -> 2 -> 1
     |         |    
     left      right

b) if list length is even,
starting point of left part is at slow, but remember to set slow.next to prev as that's not done in the traverse in step 1.
starting point of right part is at next node of current slow node.
Now it looks like
1 <- 2 <- 3    3 -> 2 -> 1
          |    |    
          left right
          
4. Return false if left node and right node have different value, otherwise return true.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, prev = null, slow = head, next = head.next;
        
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
            next = next.next;
        }

        ListNode left = null, right = null;
        
        if(fast.next == null) { // list length is odd number
            left = prev;
            right = next;
        } else {                // list length is even number
            slow.next = prev;
            left = slow;
            right = next;
        }
        
        while(left != null && right != null) {
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
