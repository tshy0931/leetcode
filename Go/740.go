/*
Dynamic Programming

Create 2 slices, take and notake, to store max earn at i when taking or skipping nums[i], 
one for when we take nums[i], the other for when we don't take nums[i]. 

Sort nums in ascending order so for nums[i] we only need to care about nums[i-1].
a. if nums[i-1] == nums[i], we'll always take or skip nums[i] and nums[i-1] together;
b. if nums[i-1] == nums[i] - 1, we can only take one of them, so go for the better one, by
    max earn at i = Max of "max earn when skipping nums[i-1] plus nums[i]" and "max earn when taking nums[i-1]"
c. otherwise, 
    max earn at i = Max of "max earn when skipping nums[i-1] plus nums[i]" and "max earn of taking nums[i-1] plus nums[i]"
    
Remember to always update both take and notake earns for each i.
*/
func deleteAndEarn(nums []int) int {
    sort.Ints(nums)
    leng := len(nums)
    take, notake := make([]int, leng), make([]int, leng)
    var max int
    for i,n := range nums {
        switch {
        case i == 0:
            take[0] = n
            max = n
        case nums[i-1] == n:
            take[i] = take[i-1] + n
            notake[i] = notake[i-1]
        case nums[i-1] == n-1:
            take[i] = notake[i-1] + n
            if take[i-1] > notake[i-1] {
                notake[i] = take[i-1]
            } else {
                notake[i] = notake[i-1]   
            }
        case nums[i-1] != n-1:
            if take[i-1] > notake[i-1] {
                take[i] = take[i-1] + n
                notake[i] = take[i-1]
            } else {
                take[i] = notake[i-1] + n
                notake[i] = notake[i-1]
            }
        }
        if take[i] > max {
            max = take[i]
        }
        if notake[i] > max {
            max = notake[i]
        }
    }
    return max
}
