/*
start from both end and move towards center of array.
There must be a peak because both side need to be increasing, otherwise a peak is found.
*/
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        
        int l = 1, r = nums.length-2;
        while(l <= r){
            if(nums[l] > nums[l+1]) return l;
            if(nums[r] > nums[r-1]) return r;
            ++l;
            --r;
        }
        
        return -1;
    }
}
