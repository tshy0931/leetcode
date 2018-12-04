/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n <= 0) return 0;
        int l=1, r=n, mid;
        while(l < r){
            mid = l + (r-l) / 2; // to avoid l+r exceeding max integer value
            if(isBadVersion(mid)){
                r = mid; // mid itself is still possible to be the result
            }else{
                l = mid + 1; // mid won't be result, so skip it
            }
        }
        return l;
    }
}
