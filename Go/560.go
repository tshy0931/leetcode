/*
1. Brute Force
For each i in nums, possible sums ending at i are
a) nums[i] itself
b) each possible value ending at i-1 + nums[i]

2. 
target is to find all i,j that sums from i to j equals k. which is
    sum(0, j) - sum(0, i) == k
go thru the array to compute running sum ending at each index, j.
use a map to store times of a sum occurred.
therefore, memo[sum - k] (count of sum-k) means how many we have found so far.
*/
func subarraySum(nums []int, k int) int {
    memo := map[int]int{0:1}
    count, sum := 0, 0
    for _, n := range nums {
        sum += n
        count += memo[sum - k]
        memo[sum] += 1
    }
    return count
}
