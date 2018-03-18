/*
1. Dynamic Programming

Use an array, dp, to store minimum number of jumps to index i at dp[i].
dp[i] is the minimum of dp[j], where j is any index that is possible to jump to index i.

dp[i] = min(dp[j]), where j + nums[j] >= i

2. Greedy

For each jump, we find the maximum index we can reach in next jump, by
maxJump = max(nums[i] + i), where i is each possible index we can jump to in current step.

Then for next jump, the range of possible index to jump to is [end of curr jump + 1, maxJump of curr jump]
[3,   1,   2,   3,   2,   1,   3,   4,   2]
 |- curr  jump -|
                |- next  jump -|
*/
import "math"

func jump(nums []int) int {
    
    jumps, maxLeng, end := 0, 0, 0
    
    for i:=0 ; i< len(nums)-1; i++ {
        if i+nums[i] > maxLeng {
            maxLeng = i+nums[i]
        }
        if i == end {
            jumps++
            end = maxLeng
        }
    }
    return jumps
    
//     leng := len(nums)
//     dp := make([]int, leng)

//     for i := 1; i < leng; i++ {
//         dp[i] = findMin(nums, i, dp)
//     }
//     return dp[leng-1]
}

// func findMin(nums []int, at int, dp []int) int {
//     min := math.MaxInt32
//     for i := 0; i < at; i++ {
//         if nums[i] + i >= at && dp[i] < min {
//             min = dp[i]
//         }
//     }
//     return min+1
// }
