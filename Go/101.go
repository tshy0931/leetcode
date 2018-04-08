/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
/**
to be symmetric, for each node in the tree,
0) the 2 nodes to check can only both be nil. not symmetric is only one is nil.
1) values of left/right child nodes should equal
2) right child of left child should be symmetric to left child of right child
3) left child of right child should be symmetric to right child of left child
*/
func isSymmetric(root *TreeNode) bool {
    if root == nil {
        return true
    }
    return is(root.Left, root.Right)
}

func is(left *TreeNode, right*TreeNode) bool {
    if left==nil && right==nil {
        return true
    }
    if left==nil || right==nil {
        return false
    }
    if left.Val != right.Val {
        return false
    }
    return is(left.Left, right.Right) && is(left.Right, right.Left)
}
