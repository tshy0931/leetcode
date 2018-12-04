/*
Use binary search to find the number n that n*n == x or (n*n < x && (n+1)*(n+1)).
Start with range [0, n/2+1] because sqrt of a number greater than 2 won't be greater than x/2.

Edge cases to consider:
1) number of 0, 1, 2.
2) numbers whose square exceed max integer value. (to avoid this, use x/mid instead of mid*mid)
*/
class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l = 0, r = x/2+1, mid = -1;
        while(l < r){
            mid = (l + r) / 2;
            if(mid == x/mid) return mid;
            if(mid < x/mid){
                if(mid+1 > x/(mid+1)) return mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return l;
    }
}
