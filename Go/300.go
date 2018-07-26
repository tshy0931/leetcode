/*
Dynamic Programming

for index k, longest subsequence ending at k is the max length of subsequence that ends at a number before k and the elem is less than k.
Keep a running maximum and return that when all elems in nums are processed.

    dp[k] = max(dp[j]) + 1 where j < k and nums[j] < nums[k]

*/
func lengthOfLIS(nums []int) int {
    if nums == nil {
        return 0
    }
    leng := len(nums)
    if leng == 0 {
        return 0
    }

    dp := make([]int, leng, leng)
    dp[0] = 1
    max := dp[0]
    
    for i:=1; i<leng; i++ {
        for j:=i-1; j>=0; j-- {
            if nums[j] < nums[i] && dp[j] > dp[i] {
                dp[i] = dp[j]
            }
        }
        dp[i]++
        if dp[i] > max {
            max = dp[i]
        }
    }
    return max
}
