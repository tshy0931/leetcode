/*
Keep smallest and biggest number (init to infinity) seen so far during traversal.
if a number is smaller than smallest, set it to new smallest number.
if a number is greater than smallest and lower than biggest, set it to new biggest number.
Return true once we found a number greater than both numbers.
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int upper = Integer.MAX_VALUE;
        int lower = Integer.MAX_VALUE;
        
        for(int n:nums){
            if(n > upper) return true;
            if(n < lower) lower = n;
            else if(n > lower && n < upper) upper = n;
        }
        return false;
    }
}
