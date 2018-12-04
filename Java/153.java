/*
Binary Search:
if number at mid is greater than the number at right boundary, it means the rotated min value is within [mid+1, r].
*/
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int l=0, r=nums.length-1, mid;
        while(l < r){
            mid = l + (r-l) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return nums[r];
    }
}
