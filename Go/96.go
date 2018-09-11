/*
Recursive + Memoization:
at each number i in between l and r (inclusive), 
count of trees in left subtree , cl, is result of recursive call on range l, i-1;
count of trees in right subtree , cr, is result of recursive call on range i+1, r;
when i == l, it has only 1 possible left subtree, empty tree.
when i == r, it has only 1 possible right subtree, empty tree.

then multiply count of left/right subtree, that's all the possible subtree combinations when root is i.
add up all combination counts for each root value from 1 to n.
store count of l to r to avoid repeated computations.
*/
func numTrees(n int) int {
    memo := make([][]int, n+1)
    for i := range memo {
        memo[i] = make([]int, n+1)
    }
    return count(1, n, memo)
}

func count(l int, r int, memo [][]int) int {
    if memo[l][r] > 0 {
        return memo[l][r]
    }
    cnt, lc, rc := 0, 0, 0
    for i:=l; i<=r; i++ {
        if i == l {
            lc = 1
        } else {
            lc = count(l, i-1, memo)
        }
        if i == r {
            rc = 1
        } else {
            rc = count(i+1, r, memo)
        }
        
        cnt += lc * rc
    }
    memo[l][r] = cnt
    return cnt
}
