/**
BFS: Level-order tarversal

Starting from root, for each node, keep track of all possible sums of paths ending at current node.
Calculate possible sums for its child nodes, which contains itself value and all possible sums at its parent plus its value
Increment count when the target sum is found.

For example,
              possible sums at node
      10      10: [10]
     /  \     
    5   -3    5:  [5, 10+5], -3: [-3, 10+(-3)]
   / \    \
  3   2   11  3:  [3, 3+5, 3+15], 2: [2, 2+5, 2+15], 11: [11, 11+(-3), 11+7]
 / \   \
3  -2   1

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, sum int) int {
    if root == nil {
        return 0
    }
    count := 0
    sums := make(map[*TreeNode][]int)
    sums[root] = []int{root.Val}
    queue := make([]*TreeNode, 1, 8)
    queue[0] = root
    
    for len(queue) > 0 {
        node := queue[0]
        if node.Val == sum {
            count++
        }
        possibleSums := sums[node]
        if node.Left != nil {
            leftSums := make([]int, 1, 4)
            leftSums[0] = node.Left.Val
            for _, n := range possibleSums {
                s := node.Left.Val + n
                if s == sum {
                    count++
                }
                leftSums = append(leftSums, s)
            }
            sums[node.Left] = leftSums
            queue = append(queue, node.Left)
        }
        if node.Right != nil {
            rightSums := make([]int, 1, 4)
            rightSums[0] = node.Right.Val
            for _, n := range possibleSums {
                s := node.Right.Val + n
                if s == sum {
                    count++
                }
                rightSums = append(rightSums, s)
            }
            sums[node.Right] = rightSums
            queue = append(queue, node.Right)
        }
        if len(queue) == 1 {
            break
        }
        queue = queue[1:]
    }
    
    return count
}
