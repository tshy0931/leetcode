/**
Recursion:
Traverse the tree and pass corresponding prefix string at each node.
For each node create string like prefix + "->" + node.Val, beware of root node case where there's no "->".
When reached a leaf node, add the string to result array.
Return the array.
*For Golang, beware that when you append string to a slice itself by slice = append(slice, str), 
the reference slice has been changed, NOT the same as the one passed in.
One solution is to return reference the appended slice in recursive calls.

Iterative:
Level-order traversal using a FIFO queue. Need to store node and correspoding path string together.
Dequeue a node each time and enqueue child nodes of each node with their corresponding path.
if a node has no child nodes, add the path to resulting array.

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func binaryTreePaths(root *TreeNode) []string {
    res := make([]string, 0, 8)
    if root == nil {
        return res
    }
    return dfs(root, "", res)
}

func dfs(root *TreeNode, prefix string, res []string) []string {
    var str string
    if prefix == "" {
        str = strconv.Itoa(root.Val)
    } else {
        str = prefix + "->" + strconv.Itoa(root.Val)
    }
    if root.Left == nil && root.Right == nil {
        res = append(res, str)
    } else {
        if root.Left != nil {
            res = dfs(root.Left,  str, res)
        }
        if root.Right != nil {
            res = dfs(root.Right, str, res)    
        }
    }
    return res
}
