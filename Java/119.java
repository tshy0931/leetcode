/*
the length of k-th row will be k+1, so create an ArrayList with this length and fill with all 1's.
Values of a given row n can be computed from row n-1, for example: 
    value at index i in row n is the sum of values at index i and i-1 in row n-1
Correcly handle index bound, and notice the first and last values at each row are always 1.
To only use O(k) extra space, we calculate each row from the end of list backwards,
so that we can reuse the list without overwritting any values to be used as if from row n-1.
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) return null;
        ArrayList<Integer> res = new ArrayList<>(rowIndex+1);
        for(int k=0; k<=rowIndex; ++k) res.add(1);
        
        for(int i=1; i<rowIndex; ++i){
            for(int j=i; j>0; --j) {
                res.set(j, res.get(j) + res.get(j-1));
            }
        }
        return res;
    }
}
