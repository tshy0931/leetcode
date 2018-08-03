/*
When a trailing zero happens, it requires one 2 and one 5.
Since number of 2 are always more than that of 5, the result is determined by how many 5 we have in the n!
n * (n-1) * (n-2) * ... * 1 
only times of 5 can contain 5's, therefore just sum up number of 5's from n/5, n/5/5, n/5/5/5, ..., 5.
*/
class Solution {
    public int trailingZeroes(int n) {
        int countOf5 = 0;
        while(n >= 5){
            n /= 5;
            countOf5 += n;
        }
        return countOf5;
    }
}
