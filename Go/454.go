/*
Memoization

Basic idea is to memoize count of each possible partial sum we see as we iterate through the arrays, in order to reuse and avoid repeated computation.
Mistake I made is updating memo while iterating C, which is not atomic on C and caused additional tuples which use multiple ints in C and B.
Interesting point is I got Time Limit Exceeded error when using triple-nested iteration on B,C,D.
But it passed when it's split into double-nested, A-B and C-D. This could be useful when designing algo.
*/
func fourSumCount(A []int, B []int, C []int, D []int) int {
    memo := make(map[int]int)
    leng := len(A)
    if leng < 1 {
        return 0
    }
    var count int
    
    for _, d := range D {
        for _, c := range C {
                memo[c+d]++
        }
    }
    for _, a := range A {
        for _, b := range B {
            cnt, ok := memo[-a-b]
            if ok {
                count += cnt
            }
        }     
    }
    return count
}
