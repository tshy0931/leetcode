/*
Binary Search:
starting with range [l=1, r=num/2], compute square of mid value in the range,
a) if the square value equals num, num is a perfect square number thus return true;
b) if the square value is smaller than num, we search in [mid+1, r]
c) if the square value is greater than num, we search in [l, mid-1]

Beware that square of mid and sum of l+r both can exceed integer maximum value, so we use long type.
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        
        long l=1, r = num/2; 
        long mid, midSq;
        while(l <= r){
            mid = (l + r)/2;
            midSq = mid * mid;
            if(midSq == num) return true;
            if(midSq < num) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}
