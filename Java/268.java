/*
The target sum is always 1+2+...+n, 
so we just subtract all the numbers in nums, 
the remainder is the missing number.
BUT this solution is prone to overflow!

Use XOR instead of sum can avoid overflow.
*/
class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        //int res = 0;
        int res = nums.length;
        for(int i=0; i<nums.length; ++i){
            //res += i+1;
            //res -= nums[i];
            res = res ^ i ^ nums[i];
        }
        return res;
    }
}
