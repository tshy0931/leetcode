class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length-1, mid = -1;
        while(l<=r){
            mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) r = mid - 1;
            else if(nums[mid] < target) l = mid + 1;
        }
        return -1;
    }
}
