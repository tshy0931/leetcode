/**
Dynamic Programming

a given sum 11 can be achieved by 3 ways, 
A) take £5 from 11-5=6,  coin count = 1 + min count you need to have £6
B) take £2 from 11-2=9,  coin count = 1 + min count you need to have £9
C) take £1 from 11-1=10, coin count = 1 + min count you need to have £10
Of course we choose the min count from A), B) and C). And that applies to all sums.
So we only keep track of min coin count to have a sum, say N (0 <= N <= target amount).
If there's no way to achieve the target amount, return -1
*/
func coinChange(coins []int, amount int) int {
    if amount == 0 {
        return 0
    }
    dp := make([]int, amount+1)
    leng := len(coins)
    for i:= 1; i<=amount; i++ {
        dp[i] = amount+1
    }
    if leng == 0 {
        return -1
    }
    for i, _ := range dp {
        for _, v := range coins {
            if prev:=i-v; prev >= 0 && dp[prev] >= 0 {
                if dp[prev]+1 < dp[i] {
                    dp[i] = dp[prev]+1
                }
            }
        }
    }
    if dp[amount] > amount {
        return -1
    }
    return dp[amount]
}
