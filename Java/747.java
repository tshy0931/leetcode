/*
Find the largest 2 numbers in the array, and check if the largest one is at least twice larger than the other.
*/
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int index = -1;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > first) {
                second = first;
                first = nums[i];
                index = i;
            } else if(nums[i] > second) {
                second = nums[i];
            }
        }
        return first >= (second << 1) ? index : -1;
    }
}
