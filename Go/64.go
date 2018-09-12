/*
Dynamic Programming:
Use a grid of the same size, sum, to track minimum path sum to each cell.
for each cell grid[i][j], the minimum path sum to it is
    sum[i][j] = 1 + Min(sum[i-1][j], sum[i][j-1])
Beware of cells on the edge of grid to avoid index-out-of-bound error.

Return value at bottom-right corner of sum.

Improvement:
actually a 1-dimentional array of the same width as grid is sufficient.
Because we only need the value on left and top of a particular cell, 
which are present before we compute the path sum of current cell.
*/
func minPathSum(grid [][]int) int {
    if grid == nil {
        return 0
    }
    if len(grid) == 0 {
        return 0
    }
    
    w := len(grid[0])
    
    if w == 0 {
        return 0
    }
    
    sum := make([]int, w)
    sum[0] = grid[0][0]
    
    for i, row := range grid {
        if i == 0 {
            for j := range row {
                if j > 0 {
                    sum[j] += grid[i][j] + sum[j-1]
                }
            }
        } else {
            for j := range row {
                if j == 0 {
                    sum[0] += grid[i][j]
                } else {
                    if sum[j-1] < sum[j] {
                        sum[j] = grid[i][j] + sum[j-1]
                    } else {
                        sum[j] += grid[i][j]
                    }
                }
            }
        }
    }  
    return sum[w-1]
}
