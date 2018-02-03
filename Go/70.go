func climbStairs(n int) int {
    c := [n+1]int{}
    c[0] = 1
    c[1] = 1
    for i := 2; i < n; i++ {
	// Dynamic Programming
	// for i-th stair, we can get there in 2 ways:
	// 1) climb 1 step from stair n-1
	// 2) climb 2 steps from stair n-2
	// hence the number of ways is the sum of 1) and 2)
	// can be generalized to more steps allowed in a move.
        c[i] = c[i-1] + c[i-2]
    }
    return c[n]
}
