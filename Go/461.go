/**
x XOR y will set 1 where x and y have different bit
let z = x XOR y, z - 1 will flip the last set bit in z to 0 and following bits to 1, due to borrowing.
e.g. 00101000 
   - 00000001 
   = 00100111
then z & (z-1) will set all the flipped bits to 0, as 1 & 0 = 0
     00101000
   & 00100111
   = 00100000
therefore we repeat this until z becomes 0, where all set bits are removed.
return the repeated times as number of set bits
*/
func hammingDistance(x int, y int) int {
    z, d := x ^ y, 0
    for z!=0 {
        z &= z-1
        d++
    }
    return d
}
