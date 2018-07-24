/*
use two pointers to track where to place next 0 and 2
p0: next place to put 0, starting from 0. elems before p0 are all 0
p2: next place to put 2, starting from last index in nums. elems after p2 are all 2

traverse the array and swap 0 and 2 and update p0 and p2
*/
func sortColors(nums []int)  {
    leng := len(nums)
    p0, p2 := 0, leng-1
    
    for i, n := range nums {
        for p2 > i && nums[p2] == 2 {
            p2--
        }
        if i >= p2 {
            if n == 0 {
                nums[p0], nums[i] = 0, nums[p0]
            }
            return
        }
        switch(n){
            case 0:
                nums[p0], nums[i] = 0, nums[p0]
                p0++
                
            case 2:
                switch(nums[p2]){
                    case 0:
                    tmp := nums[p0]
                    if i > p0 {
                        nums[i] = tmp
                    }
                    nums[p0] = 0
                    p0++
                    nums[p2] = 2
                    p2--

                    case 1:
                        nums[i], nums[p2] = 1, 2
                        p2--
                }            
        }
    }
}
