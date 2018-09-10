/*
traverse all cells and when an island '1' is found, check adjacent '1' cells to count area size.
Can use either of below approach to track cells already visited.
    1) another grid of same size - more memory consumption
    2) use higher digit of cell value to store visited state in the same cell - require another traversal to restore original input grid
Keep record of the max area size have been seen.
*/
func maxAreaOfIsland(grid [][]int) int {
    max := 0
    h, w := len(grid), len(grid[0])
    visited := make([][]int, h)
    for i := range visited {
        visited[i] = make([]int, w)
    }
    
    for i, row := range grid {
        for j := range row {
            area := getArea(i, j, grid, visited, h, w)
            if area > max {
                max = area
            }
        }
    }
    return max
}

func getArea(i int, j int, grid [][]int, visited [][]int, h int, w int) int {
    if i < 0 || i >= h || j < 0 || j >= w || grid[i][j] != 1 || visited[i][j] == 1 {
        return 0
    }
    area := 1
    visited[i][j] = 1
    area += getArea(i-1, j, grid, visited, h, w)
    area += getArea(i+1, j, grid, visited, h, w)
    area += getArea(i, j-1, grid, visited, h, w)
    area += getArea(i, j+1, grid, visited, h, w)
    
    return area
}
