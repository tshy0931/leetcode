/*
Use two pointers, h at first element and t at last one.
iterate the array with h, when h points to a value that equals to the target,
swap values at h and t and move t backward.
Beware that whenever t points to a target value, we need to move it backward
to avoid swapping the target value back to h.
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int tmp;
        int h=0,t=nums.length-1;

        while(h<=t) {
            if(nums[t] == val) {
                --t;
                continue;
            }
            
            if(nums[h] == val) {
                tmp = nums[h];
                nums[h] = nums[t];
                nums[t] = tmp;
                --t;
            }
            ++h;
        }
        return h;
    }
}
