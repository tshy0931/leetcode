/**
XOR is adding two numbers without carry, because 1 ^ 1 = (1)0 
AND shows where the digits are both 1, hence a carry is needed, as 1 & 1 = 1
shift to left by 1 to make the carry work on higher digit.
eventually there will be no more carry, so loop until then.
*/
func getSum(a int, b int) int {
    sum, carry := a ^ b, (a & b) << 1
    for carry != 0 {
        tmp := sum ^ carry
        carry = (carry & sum) << 1
        sum = tmp
    }
    return sum
}
