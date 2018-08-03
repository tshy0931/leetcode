/*
Traverse the array and keep track of:
1) current number to dedup. 
2) next index to store the next unique number. 
3) the length of resulting array.

When a duplicate number is met, pass through all the following duplicate numbers until a different number is met.
copy that number into the next index as described in 2) and increment the next index.
update current number to be the different number and repeat.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) return 1;
        
        int nextPos = 1;
        int length = 1;
        int currNum = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == currNum) {
                while(i < nums.length && nums[i] == currNum) i++;
            }
            if(i == nums.length) break;
            length++;
            nums[nextPos++] = nums[i];
            currNum = nums[i];
        }
        
        return length;
    }
}
