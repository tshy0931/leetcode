/*
keep the max length we find so far while iterating the array,
and the length of current consequtive 1s.
when we hit a 0, update the max length if current one is longer, and reset current length to 0.
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int currLen = 0, maxLen = 0;
        
        for(int n : nums){
            if(n == 1) {
                currLen++;
            } else {
                maxLen = Math.max(currLen, maxLen);
                currLen = 0;
            }
        }
        maxLen = Math.max(currLen, maxLen);
        return maxLen;
    }
}
