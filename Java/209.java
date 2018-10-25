/*
use two pointers h, t both at first element in the array.
keep track of min size found so far, and the sum of numbers in the window formed by h and t.
add number at h to the sum, if
a) sum >= s, then update min size if current window is shorter, then move t forward;
b) sum < s, not enough sum, move h forward to increase window size and sum;
If there is a number greater than s, return 1 as it cannot be shorter.
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int h = 0, t = 0, sum = nums[0], min = Integer.MAX_VALUE;
        boolean found = false;
        while(h < nums.length) {
            // if(nums[h] >= s) return 1;

            if(sum < s) {
                if(++h == nums.length) return found ? min : 0;
                sum += nums[h];
            } else {
                found = true;
                min = Math.min(h - t + 1, min);
                sum -= nums[t++];
            }
        }
        if(sum > s) {
            min = Math.min(h - t + 1, min);
        }
        return found ? min : 0;
    }
}
