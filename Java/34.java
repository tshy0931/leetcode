/*
1) binary search to find a target number
2) binary search to both left & right of the target number we found, to find the first & last index of the same number
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length==0) return new int[]{-1, -1};
        int l=0, r=nums.length-1, mid;
        while(l<=r){
            mid = l + (r-l) / 2; 
            if(nums[mid] == target){
                // found a target number, search for start and end indices
                int start = findStart(nums, l, mid, target);
                int end = findEnd(nums, mid, r, target);
                return new int[]{start, end};
            }
            if(nums[mid] < target) l = mid+1;
            else r = mid-1;
        }

        return new int[]{-1, -1};
    }
    
    private int findStart(int[] nums, int l, int r, int target) {
        int mid;
        while(l<r){
            mid = l + (r-l)/2;
            if(nums[mid] == target) {
                r = mid; // found another target number, the start could be mid or on its left side
            } else {
                l = mid+1; // found a non-target number, the start must be on the right side of mid
            }
        }
        return r;
    }
    
    private int findEnd(int[] nums, int l, int r, int target) {
        int mid;
        while(l<r-1){
            mid = l + (r-l)/2;
            if(nums[mid] == target) {
                l = mid; // found another target number, the end could be mid or on its right side
            } else {
                r = mid-1; // found a non-target number, the end must be on the left side of mid
            }
        }
        return nums[r] == target ? r : l;
    }
}
