mic Programming

for target K, the possible combinations must come from
    all combinations of K-a + a,
    all combinations of K-b + b,
    all combinations of K-c + c,
    ...
where a, b, c, ... are in the candidates.

So use an array to store combinations of from 0 to target K
*/
func combinationSum(candidates []int, target int) [][]int {
    leng := len(candidates)
    if leng == 0 {
        return nil
    }
    dp := make([][][]int, target+1)
    dp[0] = [][]int{[]int{}}
    sort.Ints(candidates)
    
    for i:=1; i<len(dp); i++ {
        for _, c := range candidates {
            if c > i {
                break
            }
            for _, comb := range dp[i - c] {
                newComb := make([]int, len(comb)+1)
                copy(newComb, comb)
                newComb[len(comb)] = c
                sort.Ints(newComb)
                if !isDup(dp[i], newComb) {
                    dp[i] = append(dp[i], newComb)
                }
            }
        }
    }
    return dp[target]
}

func isDup(combs [][]int, newComb []int) bool {
    for _, comb := range combs {
        if len(comb) == len(newComb) {
            for i, n := range comb {
                if n != newComb[i] {
                    goto Next
                }
            }
            return true
        }
        Next:
    }
    return false
}
