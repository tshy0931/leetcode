/*
O(N), use a hashmap to store count of each integer in the nums array.
if k == 0, just count how many integers appear more than once.
otherwise, increment count when the integer - k or the integer + k exists in the hashmap, since k is absolute diff.
*/
func findPairs(nums []int, k int) int {
    if nums == nil || len(nums) < 2 || k < 0 {
        return 0
    }

    dict, count := make(map[int]int), 0
    
    for _, n := range nums {
        if k > 0 && dict[n] == 0 {
            if dict[n - k] > 0 {
                count++
            }
            if dict[n + k] > 0 {
                count++
            }
        }
        dict[n]++
    }
    
    if k == 0 {
        for _, v := range dict {
            if v > 1 {
                count++
            }
        }
    }
    
    return count
}
