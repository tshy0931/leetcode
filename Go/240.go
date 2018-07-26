/*
Better solution: Starting from top-right corner,
if the cell is larger than target, the target cannot be in the same column, so move left
if the cell is smaller than target, the target cannot be in the same row, so move down
if equals just return true, else return false after finished search
*/
func searchMatrix(matrix [][]int, target int) bool {
    if matrix == nil {
        return false
    }
    h := len(matrix)
    if h == 0 {
        return false
    }
    w := len(matrix[0])
    if w == 0 {
        return false
    }
    if matrix[0][0] > target {
        return false
    }
    
    for i,j := 0,w-1; i<h && j>=0; {
        switch {
            case matrix[i][j] > target:
                j--
            case matrix[i][j] == target:
                return true
            case matrix[i][j] < target:
                i++
        }
    }
    return false
}

/*
The elements on the diagnal line is the largest number in the sub-matrix framed by the diagnal line.
the target cannot be in the sub-matrix where target is greater than the diagnal element.

func searchMatrix(matrix [][]int, target int) bool {
    if matrix == nil {
        return false
    }
    h := len(matrix)
    if h == 0 {
        return false
    }
    w := len(matrix[0])
    if w == 0 {
        return false
    }
    if matrix[0][0] > target {
        return false
    }
    
    rank := h
    if w < h {
        rank = w
    }
    i := 0
    for ;i<rank; i++ {
        if matrix[i][i] == target {
            return true
        }
        if matrix[i][i] > target {
            for j:=i; j>=0; j-- {
                if matrix[i][j] == target || matrix[j][i] == target {
                    return true
                }
            }
        }      
    }
    
    for ;i < h; i++ {
        for j:=0; j<w; j++ {
            if matrix[i][j] == target {
                return true
            }
            if matrix[i][j] > target {
                break
            }
        }
    }
    
    for ;i < w; i++ {
        for j:=0; j<h; j++ {
            if matrix[j][i] == target {
                return true
            }
            if matrix[j][i] > target {
                break
            }
        }
    }
    
    return false
}
*/
