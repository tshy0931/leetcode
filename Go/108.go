/**
Recursive:
Split the array in the middle point, the split point is current TreeNode, 
and its left/right child will be the split point of left/right part.
if only one element left after split, return that as a leaf node.
Do this recursively.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedArrayToBST(nums []int) *TreeNode {
    return bst(nums, 0, len(nums)-1)
}

func bst(nums []int, l int, r int) *TreeNode {
    if l > r || l < 0 || r < 0 || l > len(nums) || r > len(nums) {
        return nil
    }
    if l==r {
        return &TreeNode{nums[l], nil, nil}
    }
    mid := (l+r)/2
    left := bst(nums, l, mid-1)
    right := bst(nums, mid+1, r)
    return &TreeNode{nums[mid], left, right}
}
