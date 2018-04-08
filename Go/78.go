/**
keep a slice, S, to store subsets we've found so far.
S intially contains an empty subset.
then loop thru nums, for each nums[i], 
create subsets by appending nums[i] to each subset in S, 
append these new subsets to S.

There's a gotcha in Go implementation that it may cause unexpected behavior when you append a slice to a slice.
Test cases were failing when nums has more than 4 elements. I'm guessing the default cap of slice might be 4,
and strange behavior happened when I append slices without copying first.
copy the slice to a new one before appending solves it.
*/
func subsets(nums []int) [][]int {
    empty := []int{}
    sets := [][]int{empty}
    for _, n := range nums {
        newSets := make([][]int,0)
        for _, set := range sets {
            tmp := make([]int, len(set)+1)
            copy(tmp, append(set,n))
            newSets = append(newSets, tmp)
        }
        sets = append(sets, newSets...)
    }
    return sets
}
