/*
1) binary search to find the number in arr that is closest to target x, 2 situations here:
    a) we found a value that equals to x, stop the binary search.
    b) there's no same value as x in arr, the binary search will end at two adjacent numbers that are closest to x, choose the closer one.
    
2) centered at the closest number, we span to left and right adjacent numbers and choose the k-1 numbers closer to x.
   beware of index out of bound cases and result the numbers in order.
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null | arr.length == 0) return result;
        
        int l=0, r=arr.length-1, mid;
        while(l<r-1) {
            mid = l + (r-l)/2;
            if(arr[mid] == x) {
                l = mid;
                break;
            }
            if(arr[mid] < x) l = mid;
            else r = mid;
        }
        // l and r are the ones closest to x
        int closestAt = Math.abs(x - arr[l]) < Math.abs(x - arr[r]) ? l : r;

        int start = closestAt-1, end = closestAt+1, count = k-1; // the closest number must be in the result, so we need k-1 more numbers
        while(start >= 0 && end < arr.length && count > 0){
            if(Math.abs(x - arr[start]) <= Math.abs(x - arr[end])) { // number on left is closer
                --start;
            } else {
                ++end;
            }
            --count;
        }
        while(count > 0){
            --count;
            if(start < 0){ // all heading numbers are taken
                ++end;
            } else { // all tailing numbers are taken
                --start;
            }
        }

        for(int i=0; i<k; ++i){
            result.add(arr[start+1+i]);
        }
        return result;
    }
}
