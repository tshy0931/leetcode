/*
Binary search, return index when it's a peak by definition
*/
func findPeakElement(nums []int) int {
    leng := len(nums)
    
    if nums == nil || leng == 0 {
        return -1
    }
    
    if leng == 1 {
        return 0
    }
    if nums[1] < nums[0] {
        return 0
    }
    if nums[leng-2] < nums[leng-1] {
        return leng-1
    }
    
    l, r, mid := 0, len(nums), 0
    
    for l < r {
        mid = (l+r)/2
        if nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid] {
            return mid
        }
        if nums[mid-1] < nums[mid] {
            l = mid
        } else {
            r = mid
        }
    }
    return -1
}
