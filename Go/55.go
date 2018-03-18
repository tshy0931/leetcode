/*
Traverse the array from left to right and keep record of the furthest index we can reach as maxPos.
If we find an index i which is greater than maxPos, that means it's impossible to reach i from any of the previous indices. 
*/
func canJump(nums []int) bool {
    maxPos := 0

    for i, n := range nums {
        if maxPos < i {
            return false
        }
        if i + n > maxPos {
            maxPos = i + n
        }
    }
    return true
}
