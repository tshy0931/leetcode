/*
Dynamic Programming solution

for each number, nums[i], we record both maximum and minimum products that ENDS AT i.
we have 3 possible choices when finding min/max at i:
    a. nums[i] itself
    b. nums[i] * min[i-1]
    c. nums[i] * max[i-1]
Then we find the max of the 3 above as max product at i,
             the min of the 3 above as min product at i
             
Keep currently max product and return when we finish iterating nums.
*/
func maxProduct(nums []int) int {
    
    // store both max/min product at each
    max, min := make([]int, len(nums)), make([]int, len(nums))
    max[0] = nums[0]
    min[0] = nums[0]
    maxN := max[0]
    var n1, n2 int
    
    for i := 1; i < len(nums); i++ {
        n1 = nums[i] * min[i-1]
        n2 = nums[i] * max[i-1]
        // find min and max in n1, n2, nums[i]
        if n1 < n2 {
            min[i] = n1
            max[i] = n2
        } else {
            min[i] = n2
            max[i] = n1
        }
        if nums[i] < min[i] {
            min[i] = nums[i]
        } else if nums[i] > max[i] {
            max[i] = nums[i]
        }
        if maxN < max[i] {
            maxN = max[i]
        }
    }
    return maxN
}
