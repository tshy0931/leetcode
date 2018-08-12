/**
Recursive:
Dynamic Programming
at each node n there are 2 possible choices.
a) n.Val + Max(not rob n.Left) + Max(not rob n.Right).
b) not rob n, Max of rob either of n.Left or n.Right or both.

Use a map to track max values of robbing/not robbing at each node, and return the larger sum that can be achieved at root node.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rob(root *TreeNode) int {
    if root == nil {
        return 0
    }
    
    robRoot, notRobRoot := choose(root)
        
    if robRoot > notRobRoot {
        return robRoot
    } else {
        return notRobRoot
    }
}

func choose(node *TreeNode) (rob int, notRob int) {
    if node == nil {
        return 0, 0
    }
    
    robL, notRobL := choose(node.Left)
    robR, notRobR := choose(node.Right)
    
    rob, notRob = node.Val, 0
    rob += notRobL + notRobR
    
    if robL > notRobL {
        notRob += robL
    } else {
        notRob += notRobL
    }

    if robR > notRobR {
        notRob += robR
    } else {
        notRob += notRobR
    }
    
    return
}
