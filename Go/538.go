/**
Traverse the BST from largest node to smallest node, and keep a running sum of values of visited nodes.
At each node, store its value v, update the value to v + running_sum, and add v to the running sum.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func convertBST(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    stack := make([]*TreeNode, 0, 32)

    for p := root; p != nil; p = p.Right {
        stack = append(stack, p)
    }
    sum := 0
    
    for {
        stackSize := len(stack)
        if stackSize <= 0 {
            return root
        }
        
        n := stack[stackSize-1]
        stack = stack[:stackSize-1]
        v := n.Val
        n.Val += sum
        sum += v
        
        if n.Left != nil {
            for q := n.Left; q != nil; q = q.Right {
                stack = append(stack, q)
            }
        }
    }
    return root
}
