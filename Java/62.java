/*
Dynamic Programming

Let P[i,j] denote number of unique paths to location (i,j), then
P[i,j] = P[i-1,j] + P[i, j-1]
*/
class Solution {
    
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1) return 0;
        int[][] paths = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    paths[0][0] = 1;
                }else{
                    if(i>0) paths[i][j] += paths[i-1][j];
                    if(j>0) paths[i][j] += paths[i][j-1];
                }
            }
        }
        
        return paths[m-1][n-1];
    }
}
