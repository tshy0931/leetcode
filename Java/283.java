/*
iterate the array and use a pointer to track the next index to place non-zero value.
We will be always moving non-zero value backwards, 
so it won't overwrite any value we haven't processed so far.
Once all non-zero values are placed, fill the rest with 0's.
*/
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int next = 0;
        
        for(int i=0; i<nums.length; ++i){
            if(nums[i] != 0){
                nums[next++] = nums[i];
            }
        }
        while(next < nums.length){
            nums[next++] = 0;
        }
    }
}
