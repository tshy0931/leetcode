/*
Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

------------------

DFS

1. iterate through the board to find the first char in the word.
2. then start checking surrounding cells for next char in the word, recursively.
3. remember to mark cells in use because cells cannot be reused.

*/
func exist(board [][]byte, word string) bool {
    used := make([][]bool, len(board))
    for i, _ := range used {
        used[i] = make([]bool, len(board[i]))
    }
    
    found := false
    for i, col := range board {
        for j, ch := range col {
            if ch == word[0] {
                found = check(i,j,1,board,word, used)
                if found {
                    return true
                }
            }
        }
    }
    return false
}

func check(i int, j int, at int, board [][]byte, word string, used [][]bool) bool {
    if at == len(word) {
        return true
    }
    
    target, found := word[at], false
    used[i][j] = true
    
    if j > 0 && !used[i][j-1] && board[i][j-1] == target {
        
        found = found || check(i, j-1, at+1, board, word, used)
    }
    if j < len(board[0]) - 1 && !used[i][j+1] && board[i][j+1] == target {
        found = found || check(i, j+1, at+1, board, word, used)
    }
    if i > 0 && !used[i-1][j] && board[i-1][j] == target {
        found = found || check(i-1, j, at+1, board, word, used)
    }
    if i < len(board) - 1 && !used[i+1][j] && board[i+1][j] == target {
        found = found || check(i+1, j, at+1, board, word, used)
    }
    used[i][j] = false
    return found
}
