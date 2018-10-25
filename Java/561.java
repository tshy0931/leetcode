/*
The largest number in nums will definitely be dropped, 
then the maximum value it can save in min(n1, n2) is
the second-largest number in nums.

Therefore we sort the array and sum up the every other number in the array, 
starting from second-last number backwards.
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i=nums.length-2; i>=0; i-=2) {
            res += nums[i];
        }
        return res;
    }
}
