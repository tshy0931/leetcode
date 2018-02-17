/*
1. keep an index, i, to track how many times we've picked random numbers. Index i in for loop is a natural choice.
2. use random [0,length - i) to pick a number n in nums, so we don't pick numbers more than once.
3. everytime we pick a random number, swap it to the end of slice, s[length-1-i].
*/
import (
    "math/rand"
)

type Solution struct {
    initial []int
}


func Constructor(nums []int) Solution {
    return Solution{nums}
}


/** Resets the array to its original configuration and return it. */
func (this *Solution) Reset() []int {
    return this.initial
}


/** Returns a random shuffling of the array. */
func (this *Solution) Shuffle() []int {
    s := make([]int, len(this.initial))
    leng := len(s)
    copy(s, this.initial)
    var r,tmp int
    for i,_ := range s {
        r = rand.Intn(leng-i)
        tmp = s[leng-1-i]
        s[leng-1-i] = s[r]
        s[r] = tmp
    }
    return s
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Reset();
 * param_2 := obj.Shuffle();
 */
