/**
use a map to track used sum. 
if a sum has already been used, it's endless loop, return false,
if sum is 1, return true.
*/
func isHappy(n int) bool {
    used := make(map[int]bool)
    used[n] = true
    curr := n
    for ;curr != 1; {
        newN := 0
        for ;curr > 0; curr /= 10 {
            c:=curr%10
            newN += c*c
        }
        curr = newN
        if used[curr] {
            return false
        }
        used[curr] = true
    }
    return true
}
