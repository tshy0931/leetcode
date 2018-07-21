/**
For each index, the product consists of two parts: 
a) product of elems from its left hand side, 
b) product of elems from its right hand side.

Then we can traverse the array twice, from left to right then in reverse.
1) traverse from left to right, compute the running product of elems we visited and save that to current index in the output array
e.g. for input [1,2,3,4] the running sum at each index will be 1, 1*1, 2*1, 3*2*1, now the output looks like [1, 1, 2, 6]
2) traverse from right to left, compute the running product of elems again and multiply with the product we put in output array
e.g. running sum from right to left is 2*3*4, 3*4, 4*1, 1 (here it's aligned to index order), and final result is [24, 12, 8, 6]
**/
func productExceptSelf(nums []int) []int {
    
    leng := len(nums)
    if leng == 0 {
        return []int{}
    }
    if leng == 1 {
        return []int{1}
    }
    res := make([]int, leng, leng)
    res[0] = 1
    
    leftSum, rightSum := 1, 1
    
    for i:=1; i<leng; i++ {
        leftSum *= nums[i-1]
        res[i] = leftSum
    }
    
    for i:=leng-2; i>=0; i-- {
        rightSum *= nums[i+1]
        res[i] *= rightSum
    }
    return res
}
