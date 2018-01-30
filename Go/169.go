func majorityElement(nums []int) int {
    dict := make(map[int]int) // keep a map of counts of numbers in the array
    leng := len(nums)
    for _, n := range nums {
        dict[n] = dict[n] + 1
        if dict[n] > leng/2 { // return when count of a number is majority
            return n
        }
    }
    return dict[nums[leng-1]]
}
