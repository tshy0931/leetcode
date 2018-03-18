/*
Brute Force:
For each window, traverse the elements inside window to find the max value.

Improvement:
Use a FIFO queue to hold elements that are within the window.
When we enqueue a new value, nums[i], it's safe to drop all the elements that are smaller than nums[i] in the queue,
because they will never have chance to be the maximum as lone as nums[i] is in the queue.
*/
func maxSlidingWindow(nums []int, k int) []int {
    
    if(len(nums) == 0) {
        return nums
    }
    
    res, p := make([]int, len(nums) - k + 1), 0
    
    for i := k-1; i < len(nums); i++ {
        res[p] = max(i, k, nums)
        p++
    }
    return res
}

func max(at int, k int, nums []int) int {
    max := nums[at]
    for i := at - k + 1; i <= at; i++ {
        if nums[i] > max {
            max = nums[i]
        }
    }
    return max
}
