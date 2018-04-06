/**
keep the last k elements in a slice,
shift first len(nums)-k elements to right by k,
put the elements from beginning of nums
*/
func rotate(nums []int, k int)  {
    leng := len(nums)
    k1 := k % leng
    tmp := make([]int, k1)
    copy(tmp, nums[leng-k1:])
    for i:=leng-k1-1; i>=0; i-- {
        nums[i+k1] = nums[i]
    }
    for i, n := range tmp {
        nums[i] = n
    }
}
