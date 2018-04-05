/**
FIFO for level order traversal. 
Use a pointer to indicate if the last node on current level has been reached.
as long as the queue is not empty, dequeue the head in queue, and enqueue its child nodes if exist.
When we meet last, enqueue it's child nodes and move the pointer last to last node in the queue.
remember to reverse the result slice for this specific problem.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
import (
    "container/list"
    "sort"
)

func levelOrderBottom(root *TreeNode) [][]int {
    if root == nil {
        return nil
    }
    var last *TreeNode = root
    fifo := make([]*TreeNode, 1, 100)
    fifo[0] = root
    var lvl []int
    var res [][]int
    
    for ;len(fifo) > 0; fifo = fifo[1:] {
        node := fifo[0]
        lvl = append(lvl, node.Val)
        if node.Left != nil {
            fifo = append(fifo, node.Left)
        }
        if node.Right != nil {
            fifo = append(fifo, node.Right)
        }
        if last == node {
            last = fifo[len(fifo)-1]
            res = append(res, lvl)
            lvl = nil
        }
    }
    leng := len(res)
    for i:=0; i<leng/2; i++ {
        tmp := res[i]
        res[i] = res[leng-1-i]
        res[leng-1-i] = tmp
    }
    return res
}
