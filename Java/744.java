/*
Binary Search:
if mid letter is smaller than target, it must not be the result so we set l = mid + 1.
if mid letter is greater than target, it sill can be the reuslt so we set r = mid.
if mid letter is equal to the target, there can be multiple target chars and it may not be the last one, 
so set l = mid + 1 then we can find the next target char or the first char greater than target.

The search should terminate when l == r, at that time letters[l] must be
a) the first letter greater than target, then return it as result.
b) less than or equal to target and as last number in the array (there's no greater number), 
   then return first number in the array as wrap around.
*/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters == null || letters.length == 0) return '\0';
        int l = 0, r = letters.length-1;
        int mid;
        while(l < r) {
            mid = (l + r) / 2;
            // when letters[mid] < target, we continue search in the right part
            // when letters[mid] == target, we stil search the right part, 
            // in order to get the last one in the duplicate targets, or the first number greater than target.
            if(letters[mid] <= target) l = mid+1; 
            else r = mid; // letters[mid] still can be the result, so keep it in the search range
        }
        
        return l == letters.length-1 && letters[l] <= target ? letters[0] : letters[l];
    }
}
