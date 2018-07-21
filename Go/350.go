/*
Create a map to track count of each integer appeared in nums1,
then go thru nums2 and put into intersection if the char has count > 0 in the map,
decrement the count everytime it's put into intersection.
*/
func intersect(nums1 []int, nums2 []int) []int {
    
    dict, res := make(map[int]int), make([]int, 0, len(nums2))
    for _, n := range nums1 {
        dict[n] += 1
    }
    for _, n := range nums2 {
        if dict[n] > 0 {
            res = append(res, n)
            dict[n] -= 1
        }
    }
    return res[:]
}
