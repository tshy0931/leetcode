/*
1) find index of the min value in the rotated sorted array, say min
2) if target is greater than last number in the array, binary search it in the first ordered part,
   otherwise binary search in the second ordered part
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int minAt = minAt(nums);
        // if minAt-1 < 0 which means minAt = 0 (no rotation), target has no chance to be greater than the last number.
        return target <= nums[nums.length-1] ? search(nums, minAt, nums.length-1, target) : search(nums, 0, minAt-1, target);
    }
    
    private int minAt(int[] nums) {
        int l = 0, r = nums.length-1, mid;
        while(l < r){
            mid = (l + r) / 2;
            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid+1;   
            }
        }
        return r;
    }
    
    private int search(int[] nums, int l, int r, int target) {
        int mid;
        while(l <= r){
            mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) l = mid+1;
            else r = mid - 1;
        }
        return -1;
    }
}
