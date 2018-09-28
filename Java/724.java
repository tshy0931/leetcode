/*
First get total sum,
then iterate again to calculate left and right sum divided by each index i, and return i if they equal.
*/
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        long total = 0L;
        
        for(int n : nums){
            total += n;
        }
        
        long left = 0L, right = total;
        
        for(int i=0; i<nums.length; i++){
            right -= nums[i];
            if(left == right) return i;
            left += nums[i];
        }
        
        return -1;
    }
}
