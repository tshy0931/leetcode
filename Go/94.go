/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/**
Iterative
push all the left nodes from root to stack.
Then pop the node on top of stack each time,
put value of the node to result slice and goto its right child node.
If right child exists, push it and all its left nodes onto stack.
repeat until the stack is empty which means all nodes are processed.
*/
func inorderTraversal(root *TreeNode) []int {
    if root==nil {
        return []int{}
    }
    stack := []*TreeNode{}
    res := []int{}
    curr := root

    for curr!=nil {
        stack = append(stack, curr)
        curr = curr.Left
    }
    for len(stack)>0 {
        curr = stack[len(stack)-1]
        stack = stack[:len(stack)-1]
        res = append(res, curr.Val)
        curr = curr.Right
        for curr!=nil {
            stack = append(stack, curr)
            curr = curr.Left
        }
    }
    
    return res
}
