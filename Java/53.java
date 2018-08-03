/*
Abandon a prefixing subarray if its sum is negative, since it can only reduce the total sum.
keep a running sum, currSum, initialize to nums[0]. Also keep the max sum seen so far in the traverse.
traverse starting from nums[1], first check the running sum currSum,
if currSum < 0, drop the sum and reset to value of nums[i],
otherwise, add nums[i] to currSum.
compare with running max value and replace with currSum if it's greater.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int currSum = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(currSum<0){
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            max = currSum > max ? currSum : max;
        }
        
        return max;
    }
}
