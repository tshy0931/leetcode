/*
Binary Search
when computing mid = (l+r)/2, it's left-biased.
When l==r but value is not target, l should be the place to insert.
*/
func searchInsert(nums []int, target int) int {
    if nums == nil {
        return 0
    }
    leng := len(nums)
    l, r, mid := 0, leng, 0
    for l < r {
        mid = (l + r) / 2
        switch {
            case nums[mid] == target:
                return mid
            case nums[mid] < target:
                l = mid + 1
            case nums[mid] > target:
                r = mid
        }
    }
    return l
}
