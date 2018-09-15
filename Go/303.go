/*
for each valid index i in array nums, store
1) the sum from beginning of the array to index i
2) the sum from end of the array to index i

Sum of given range i to j = total_sum_of_all_numbers - sum_from_0_to_i-1 - sum_from_j+1_to_last_index 
*/
type NumArray struct {
    Leng int
    Nums []int
    LeftSum []int
    RightSum []int
}


func Constructor(nums []int) NumArray {
    if nums == nil || len(nums) == 0 {
        return NumArray{0, nums, nums, nums}
    }
    leng := len(nums)
    leftSum, rightSum := make([]int, leng), make([]int, leng)
    leftSum[0] = nums[0]
    rightSum[leng-1] = nums[leng-1]
    
    for i:=1; i<leng; i++ {
        rIdx := leng-1-i
        leftSum[i] = nums[i] + leftSum[i-1]
        rightSum[rIdx] = nums[rIdx] + rightSum[rIdx+1]
    }
    return NumArray{leng, nums, leftSum, rightSum}
}


func (this *NumArray) SumRange(i int, j int) int {
    if i > j || this == nil || len(this.Nums) == 0 {
        return 0
    }
    if i <= 0 {
        return this.LeftSum[j]
    }
    if j >= this.Leng - 1 {
        return this.RightSum[i]
    }
    totalSum := this.RightSum[0]
    return totalSum - this.LeftSum[i-1] - this.RightSum[j+1]
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(i,j);
 */
