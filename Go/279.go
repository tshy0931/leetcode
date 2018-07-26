/*
Dynamic Programming

for number K, least number of perfect square numbers is 1 if itself is perfect square number, 
otherwise it's the mininum of K-1, K-4, K-9, ... plus 1.
    dp[K] = 1, if K is perfect square number
            min(dp[K-1], dp[K-4], dp[K-9], ...), otherwise
*/
func numSquares(n int) int {
    if n <= 0 {
        return 0
    }
    dp := make([]int, n+1, n+1)
    for i:=1;; {
        sq := i*i
        if sq <= n {
            dp[sq] = 1 
            i++
        }else{
            break
        }     
    }
    if dp[n] == 1 {
        return 1
    }
    for i:=2; i<=n; i++ {
        if dp[i] == 0 {
            dp[i] = n
            for j:=1;; {
                sq := j*j
                if sq >= i {
                    break
                }
                if dp[i-sq] + 1 < dp[i] {
                    dp[i] = dp[i-sq] + 1
                }
                j++
            }
        }
    }

    return dp[n]
}
