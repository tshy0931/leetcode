/*
Iterate the array and use a running max value to detect unsorted values (the values smaller than the running max).
When such value n is found, find index of the first number greater than n, that is the first value need to be sorted.
Each time we find such n, update the index of first number need sort.
The right boundary is the last such n value in the array.
*/
func findUnsortedSubarray(nums []int) int {
    if nums == nil {
        return 0
    }
    leng := len(nums)
    if leng < 2 {
        return 0
    }
    
    max, start, size := nums[0], -4, 0
    
    for i, n := range nums {
        if n < max {
            if start == -4 {
                start = i-1
            }
            for start >= 0 && nums[start] > n {
                start--
            }
            size = i - start
        } else {
            max = n
        }
    }
    return size
}
