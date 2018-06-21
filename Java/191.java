/*
if n < 0, init count as 1 and remove that leading '1' bit.
then repeat n &= n-1, this will clear least significant '1' bit everytime until n become 0.
  1100         1100
- 0001  ---> & 1011
= 1011       = 1000
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int pos = n < 0 ? n & 0x7FFFFFFF : n;
        int count = n < 0 ? 1 : 0;
        while(pos > 0) {
            pos &= pos-1;
            count++;
        }
        return count;
    }
}
