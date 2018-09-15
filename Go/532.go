/*
Sort the array, use two pointers starting at index 0 and 1. (return 0 if array length is smaller than 2)
compute the diff between nums[i] and nums[j],
if the diff equals k, increment count and move both i and j forward, skipping the same values.
if the diff is smaller than k, move j forward, skipping the same values.
if the diff is greater than k, move i forward, skipping the same values.
when i and j are at the same index, increment j. This will ensure it works properly when k is 0.
*/
func findPairs(nums []int, k int) int {
    if nums == nil || len(nums) < 2 || k < 0 {
        return 0
    }

    sort.Ints(nums)
    count, leng, i, j := 0, len(nums), 0, 1
    
    for j < leng {
        if i == j {
            j++
            continue
        }
        diff := nums[j] - nums[i]
        switch {
        case diff == k:
            count++
            i++
            for i < leng && nums[i] == nums[i-1] {
                i++
            }
            j++
            for j < leng && nums[j] == nums[j-1] {
                j++
            }
        case diff < k:
            j++
        case diff > k:
            i++
            for i < leng && nums[i] == nums[i-1] {
                i++
            }
        }
    }
    return count
}
