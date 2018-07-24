/*
Use map to scan rows and columns for duplicate numbers.
keep a list of 9 maps, one for each sub-box, check block while scanning all rows.
*/
func isValidSudoku(board [][]byte) bool {
    
    dict := make(map[byte]bool)
    leng := len(board)
    boxes := make([][]map[byte]bool, 0, 3)
    for i:=0; i<3; i++ {
        row := make([]map[byte]bool, 0, 3)
        for j:=0; j<3; j++ {
            row = append(row, make(map[byte]bool))
        }
        boxes = append(boxes, row)
    } 

    // check rows
    for i, row := range board {
        for j, n := range row {
            if n != '.' {
                if dict[n] {
                    return false
                }
                dict[n] = true
                box := boxes[i/3][j/3]
                if box[n] {
                    return false
                }
                box[n] = true
            }
        }
        dict = make(map[byte]bool)
    }
    
    // check columns
    for i:=0; i<leng; i++ {
        for j:=0; j<leng; j++ {
            n := board[j][i]
            if n != '.' {
                if dict[n] {
                    return false
                }
                dict[n] = true
            }
        }
        dict = make(map[byte]bool)
    }
    
    return true
}
