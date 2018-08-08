/**
Recursive:
t is subtree of s when there is a node n in s that:
1) n.Val == t.Val
2) left subtree of n == left subtree of t
3) right subtree of n == right subtree of t

Iterative:
If t is subtree of s, then sequence of traversing t should be a contiguous subsequence of traversing s in the same order.
So we traverse s and t to get the sequence strings S(s), S(t) respectively, and check if S(t) is a substring of S(s). 

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubtree(s *TreeNode, t *TreeNode) bool {
    if s == nil && t == nil {
        return true
    }
    if s == nil || t == nil {
        return false
    }
    found := isSameTree(s, t)
    if found {
        return true
    } else {
        return isSubtree(s.Left, t) || isSubtree(s.Right, t)
    }
}

func isSameTree(t1 *TreeNode, t2 *TreeNode) bool {
    if t1 == nil && t2 == nil {
        return true
    }
    if t1 == nil || t2 == nil {
        return false
    }
    return t1.Val == t2.Val && isSameTree(t1.Left, t2.Left) && isSameTree(t1.Right, t2.Right)
}
