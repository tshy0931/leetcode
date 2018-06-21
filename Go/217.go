/**
Use a map to record integers we have seen while iterating the array.
To avoid map resizing, set the initial capacity to the same as size of the array.
O(N) in time and O(N) in space, given N as size of the array.
**/
func containsDuplicate(nums []int) bool {
    
    dict := make(map[int]bool, len(nums))
    
    for _, n := range nums {
        if dict[n] == true {
            return true
        } else {
          dict[n] = true  
        }
    }
    return false
}
