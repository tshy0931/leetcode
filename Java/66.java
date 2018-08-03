/*
Need to consider carry, and that can cause array length incremented.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null | digits.length == 0) return digits;
        int carry = 0;
        int sum = 0;
        
        for(int i=digits.length-1; i>=0; --i) {
            sum = digits[i] + carry;
            if(i == digits.length-1) sum++;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if(carry == 1) {
            int[] res = new int[digits.length+1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
