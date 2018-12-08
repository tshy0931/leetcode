/*
Binary Search starting with range [l=0, r=nums.length-1]
if nums[mid] < nums[r], min number is on the left part or nums[r] itself , so set r = mid;
if nums[mid] > nums[r], min number is on the right part, set l = mid+1;
if nums[mid] == nums[r], below situations are all possible:
a) all numbers in [mid, r] are equal, then min must be at mid or mid's left part;
b) there's smaller number in (mid, r], then that smaller number must be the min;
c) there's greater number in (mid, r], then the min can only be on it's right.

Time complexity could degrade to O(N) because need to scan each number in [mid, r].
*/
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int l=0, r=nums.length-1, mid;
        while(l<r){
            mid = l + (r-l)/2;
            if(nums[mid] == nums[r]){
                // the pivot is possible to be on either side
                // so iterate thru numbers from mid to r to check whether this part is ascending
                // if there's number smaller, it must be the minimum
                // if there's number greater, the min is on right side of it.
                int p = mid;
                while(++p < r){
                    if(nums[p] > nums[r]){ // found a greater number, the min must be on its right side
                        l = p+1;
                        break;
                    }
                    if(nums[p] < nums[r]) return nums[p];
                }
                if(p == r){ // all the numbers to the right are equal, then min must be at mid or its left part
                    r = mid;
                }
            }
            else if(nums[mid] < nums[r]) r = mid;
            else l = mid+1;
        }
        
        return nums[l];
    }
}
