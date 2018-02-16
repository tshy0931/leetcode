/*
Dynamic Programming

There are 2 options for each house nums[i], 
a. rob i and get money of nums[i] plus max earn from not robbing nums[i-1]
b. not rob i and get money of max earn from robbing nums[i-1]

use slice rob/norob to record max earns of robbing/no robbing at house i. And we get DP formula as below:

    rob[i] = math.Max(rob[i-1], norob[i-1] + nums[i])
    norob[i] = math.Max(rob[i-1], norob[i-1])
*/
func rob(nums []int) int {
    
    max, leng := 0, len(nums)
    rob, norob := make([]int, leng), make([]int, leng)
    for i, n := range nums {
        switch {
        case i == 0:
            rob[0] = n
            norob[0] = 0
        default:
            rob[i] = norob[i-1] + n
            if rob[i-1] > norob[i-1] {
                norob[i] = rob[i-1]
            } else {
                norob[i] = norob[i-1]
            }
        }
        if rob[i] > max {
            max = rob[i]
        }
        if norob[i] > max {
            max = norob[i]
        }
    }
    return max
}
