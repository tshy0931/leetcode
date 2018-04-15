/**
Per definition of Pascal's triangle,
elements on the edge are always 1, inner elements have value as sum of values from the 2 elements "on its shoulder"
*/
func generate(numRows int) [][]int {
    res := make([][]int, numRows, numRows)
    if numRows < 1 {
        return res
    }
    res[0] = []int{1}
    for i:=1; i<numRows; i++ {
        row := make([]int, i+1, i+1)
        row[0] = 1
        row[len(row)-1] = 1
        if i > 1 {
            for j:=1; j<=len(row)/2; j++ {
                v := res[i-1][j-1] + res[i-1][j]
                row[j] = v
                row[len(row)-1-j] = v
            }
        }
        res[i] = row
    }
    return res
}
