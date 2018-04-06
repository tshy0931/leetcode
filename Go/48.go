/**
1. flip the matrix vertically with axis -
2. flip the matrix diagonally with axis \
*/
func rotate(matrix [][]int)  {
    leng := len(matrix)
    var tmp int
    for i:=0; i<leng/2; i++ {
        for j:=0; j<leng; j++ {
            tmp = matrix[i][j]
            matrix[i][j] = matrix[leng-1-i][j]
            matrix[leng-1-i][j] = tmp
        }
    }
    for i:=0; i<leng; i++ {
        for j:=i+1; j<leng; j++ {
            tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }
}
