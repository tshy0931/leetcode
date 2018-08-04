/*
Iterate through the matrix and "color" any adjacent '1' cells to '2' for each '1' or '2' cell.
If there is '2' in adjacent cells, then it belongs to an already found island.
Otherwise it's a new island, increase the count and "color" itself and its adjacent cells.

Beware that don't color adjancent cells that are already colored, that can cause the recursion stackoverflow.
*/
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[i].length; ++j){
                switch(grid[i][j]){
                    case '1':
                        count++;
                        color(i, j, grid);
                        break;
                }
            }
        }
        return count;
    }
    
    private void color(int i, int j, char[][] grid) {
        if(i<0 || i==grid.length || j<0 || j==grid[i].length || grid[i][j] != '1') return;
        grid[i][j] = '2';
        color(i-1, j, grid);
        color(i+1, j, grid);
        color(i, j-1, grid);
        color(i, j+1, grid);
        return;
    }
}
