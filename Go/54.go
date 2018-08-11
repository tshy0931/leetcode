/*
Control the traversal by:
1. top and bottom rows not processed yet
2. leftmost and rightmost columns not processed yet
3. current direction to traverse, simulated by North, South, West, East

The pattern on directions is:
we start going East. 
a. when going East  we always process the current top row. update top row when done and change direction to South.
b. when going South we always process the current rightmost column. update rightmost col when done and change direction to West.
c. when going West  we always process the current bottom row. update bottom row when done and change direction to North.
d. when going North we always process the current leftmost column. update leftmost col when done and change direction to East.

Finish and return the list when all the cells are processed.
*/
func spiralOrder(matrix [][]int) []int {
    h := len(matrix)
    if matrix == nil || h == 0 {
        return []int{}
    }
    w := len(matrix[0])
    size := h*w
    res := make([]int, size, size)
    top, bot, left, right := 0, h-1, 0, w-1
    const (
        N = 0
        S = 1
        W = 2
        E = 3
    )
    
    dir := E
    
    for i:=0; i<size; {
        switch(dir){
        case E:
            for col:=left; col<=right; col++ {
                res[i] = matrix[top][col]
                i++
            }
            top++
            dir = S
        case S:
            for row:=top; row<=bot; row++ {
                res[i] = matrix[row][right]
                i++
            }
            right--
            dir = W
        case W:
            for col:=right; col>=left; col-- {
                res[i] = matrix[bot][col]
                i++
            }
            bot--
            dir = N
        case N:
            for row:=bot; row>=top; row-- {
                res[i] = matrix[row][left]
                i++
            }
            left++
            dir = E
        }
    }
    return res
}
