/*
Use the first row/column to store whether set zeros to the corresponding column/row.

Beware that first row and first column require additional bool field to track, and should be processed after other row/columns are processed, otherwise it could set non-zero values in first row/column to zero, and misleading to setting zeros wrongly to those row/columns.
*/
func setZeroes(matrix [][]int)  {
    if matrix == nil || len(matrix) < 1 {
        return
    }
    setR0, setC0 := false, false
    
    for i, row := range matrix {
        for j, cell := range row {
            if cell == 0 {
                if i == 0 {
                    setR0 = true
                }
                if j == 0 {
                    setC0 = true
                }
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }
    
    for i:=1; i<len(matrix); i++ { // check from second column
        if matrix[i][0] == 0 {
            for j:=1; j<len(matrix[0]); j++ {
                matrix[i][j] = 0
            }
        }
    }
    
    for j:=1; j<len(matrix[0]); j++ { // check from second row
        if matrix[0][j] == 0 {
            for i:=1; i<len(matrix); i++ {
                matrix[i][j] = 0
            }
        }
    }
    
    if setR0 { // check first row
        for j:=0; j<len(matrix[0]); j++ {
            matrix[0][j] = 0
        }
    }
    
    if setC0 { // check first column
        for i:=0; i<len(matrix); i++ {
            matrix[i][0] = 0
        }
    }
}
