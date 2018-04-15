/**
iterate thru the board, for each cell board[i][j] we increment ship count if
1) current cell is 'X'
2) it's left adjacent cell is '.'
3) it's top adjacent cell is '.'
4) beware of cells where i==0 or j==0
*/
func countBattleships(board [][]byte) int {
    count := 0
    
    for i:=0; i<len(board); i++ {
        for j:=0; j<len(board[0]); j++ {
            if board[i][j] == 'X' {
                if i==0 && j==0 {
                    count++
                    continue
                }
                if i==0 && j>0 && board[i][j-1]=='.' {
                    count++
                    continue
                }
                if j==0 && i>0 && board[i-1][j]=='.' {
                    count++
                    continue
                }
                if i>0 && j>0 && board[i-1][j]=='.' && board[i][j-1]=='.' {
                    count++
                    continue
                }
            }
        }
    }
    return count
}
