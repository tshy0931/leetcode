/*
Trick is to first find the largest integer power of 3, say maxPower3, 
then it must fulfill maxPower3 % n for n to be power of 3.
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;
        long maxPower3 = 1;
        while(maxPower3*3 < Integer.MAX_VALUE){
            maxPower3 *= 3;
        }
        return maxPower3 % n == 0;
    }
}
