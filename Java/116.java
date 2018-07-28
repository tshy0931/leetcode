/**
Level-order tree traverse using a pointer to locate first node of each level. For each non-leaf node n,

1) n.left.next = n.right
2) if n has next, then n.right.next = n.next.left (the upper level has connected n to n.next by step 1 in upper level))

 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode first = root, curr = root;
        
        while(curr.left != null){
            curr.left.next = curr.right;
            if(curr.next != null){
                curr.right.next = curr.next.left; // essence to connect across trees, 
                                                  // curr.next was already processed in upper level by 
                                                  //"curr.left.next = curr.right";
            }
            if(curr == first) first = curr.left;
            if(curr.next == null) curr = first;
            else curr = curr.next;
        }
    }
}
