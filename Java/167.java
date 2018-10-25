/*
Use two pointers, l & r, starting from beginning and end of the array.
If the sum of numbers at pointers is
a) greater than the target, we should reduce the sum by moving r backward to a smaller number
b) smaller than the target, we should increase the sum by moving l forward to a greater number
c) equals to the target, we found the solution and just return (beware that the index is NOT 0-based)

Beware when the sum is out of Integer's bound, use long type for sum
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) return numbers;
        long sum = 0L;
        for(int l = 0, r = numbers.length-1; l < r;) {
            sum = numbers[l] + numbers[r];
            if(sum == target) {
                return new int[]{l+1, r+1};
            }
            if(sum < target) ++l;
            else --r;
        }
        
        return null;
    }
}
