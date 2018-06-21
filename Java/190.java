/**
Use bitwise operations to process each single bit and shift its position.
**/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res = 0, mask = 0x00000001;
        
        for(int i=0; i<32; i++) {
            res |= (mask & n);
            n >>>= 1;
            if(i < 31) res <<= 1;
        }
        return res;
    }
}
