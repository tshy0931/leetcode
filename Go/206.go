/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

/**
Use pointers to keep location of nodes before and after the node we are reversing, and go thru the list to reverse.
*/
func reverseList(head *ListNode) *ListNode {
    var newHead *ListNode = nil
    next := head
    for next!=nil {
        tmp := newHead
        newHead = next
        next = next.Next
        newHead.Next = tmp
    }
    return newHead
}
