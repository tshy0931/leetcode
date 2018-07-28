/*
For each cell, use a higher bit to store result.
dead -> live = 10 = 2
dead -> dead = 00 = 0
live -> dead = 01 = 1
live -> live = 11 = 3 
*/
func gameOfLife(board [][]int)  {
    
    if board == nil {
        return
    }
    h := len(board)
    if h == 0 {
        return
    }
    w := len(board[0])
    
    for i:=0; i<h; i++ {
        for j:=0; j<w; j++ {
            count := 0
            count += NW(board, i, j) & 1
            count += NE(board, i, j) & 1
            count += SW(board, i, j) & 1
            count += SE(board, i, j) & 1
            count += N (board, i, j) & 1
            count += S (board, i, j) & 1
            count += W (board, i, j) & 1
            count += E (board, i, j) & 1
            
            switch {
                case (board[i][j] & 1) == 1 && count < 2:  // under-population, live -> dead = 01 = 1
                    board[i][j] = 1
                case (board[i][j] & 1) == 0 && count == 3: // reproduction,     dead -> live = 10 = 2
                    board[i][j] = 2
                case (board[i][j] & 1) == 1 && count > 3:  // over-population,  live -> dead = 01 = 1
                    board[i][j] = 1
                case (board[i][j] & 1) == 1 && (count == 2 || count == 3): // survived, live -> live = 11 = 3 
                    board[i][j] = 3
                default:
                    board[i][j] = 0
            }
        }
    }
    
    for i:=0; i<h; i++ {
        for j:=0; j<w; j++ {
            board[i][j] >>= 1
        }
    }
}

func N(board [][]int, i int, j int) int {
    if i == 0 {
        return 0
    }
    return board[i-1][j]
}

func S(board [][]int, i int, j int) int {
    if i == len(board)-1 {
        return 0
    }
    return board[i+1][j]
}

func W(board [][]int, i int, j int) int {
    if j == 0 {
        return 0
    }
    return board[i][j-1]
}

func E(board [][]int, i int, j int) int {
    if j == len(board[0])-1 {
        return 0
    }
    return board[i][j+1]
}

func NW(board [][]int, i int, j int) int {
    if i == 0 || j == 0 {
        return 0
    }
    return board[i-1][j-1]
}

func NE(board [][]int, i int, j int) int {
    if i == 0 || j == len(board[0])-1 {
        return 0
    }
    return board[i-1][j+1]
}

func SW(board [][]int, i int, j int) int {
    if i == len(board)-1 || j == 0 {
        return 0
    }
    return board[i+1][j-1]
}

func SE(board [][]int, i int, j int) int {
    if i == len(board)-1 || j == len(board[0])-1 {
        return 0
    }
    return board[i+1][j+1]
}
