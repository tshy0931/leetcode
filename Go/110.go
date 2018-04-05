/**
Recursive:
for any node, both its left and right child nodes should be balanced, 
and their heights should not differ more than 1.
Check left child before processing right to avoid unnecessary checks.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    
    isValid, _ := check(root)
    return isValid
}

func check(root *TreeNode) (bool, int) {
    if root == nil {
        return true, 0
    }
    leftValid, leftDepth := check(root.Left)
    if !leftValid {
        return false, leftDepth+1
    }
    rightValid, rightDepth := check(root.Right)
    if !rightValid {
        return false, rightDepth+1
    }
    depth := leftDepth
    if leftDepth < rightDepth {
        depth = rightDepth
    }
    if diff := leftDepth - rightDepth; diff > 1 || diff < -1 {
        return false, depth
    }
    return true, depth+1   
}
