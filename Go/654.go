/**
Recursive: O(NlogN)
Find the largest number in the slice passed in, create a TreeNode, root, with that value and recursively do so in left and right part.
The returned TreeNode will be the Left/Right child nodes of root.

Iterative: O(N) with reference to https://en.wikipedia.org/wiki/Cartesian_tree
Iterate the array from left to right, and use a stack to keep track of TreeNodes with value on left of current value and larger than current value.

For each int n, create a TreeNode with Val as n. If the TreeNode on top of the stack has smaller value than the new TreeNode,
pop it out and assign as Left child of the new TreeNode.
When the node on top of stack now has greater value, that means the new node is on right subtree of that node, so assign the new node to Right child of that node.
Push the new node to stack and go process the next int in the array.

When finished iterating the array, the node on bottom of the stack is root node for the whole tree. Because no other node has chance to pop it out of the stack.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func constructMaximumBinaryTree(nums []int) *TreeNode {
    return iterative(nums)
}

func recursive(nums []int) *TreeNode {
    if nums == nil || len(nums) == 0 {
        return nil
    }
    max, maxAt := nums[0], 0
    for i, n := range nums {
        if n > max {
            max, maxAt = n, i
        }
    }
    left := constructMaximumBinaryTree(nums[0:maxAt])        
    right := constructMaximumBinaryTree(nums[maxAt+1:len(nums)])
    
    return &TreeNode{max, left, right}
}

func iterative(nums []int) *TreeNode {
    leng := len(nums)
    if nums == nil || leng == 0 {
        return nil
    }
    stack := make([]*TreeNode, leng, leng)
    top := 0

    for _, n := range nums {
        node := &TreeNode{n, nil, nil}
        for top > 0 && stack[top-1].Val < n {
            node.Left = stack[top-1]
            top--
        }
        if top > 0 {
            stack[top-1].Right = node
        }
        stack[top] = node
        top++
    }
    
    return stack[0]
}
