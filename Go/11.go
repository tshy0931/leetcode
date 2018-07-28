/*
Greedy Algorithm

Starting from left-most and right-most bars, choose one side (the longer bar because that contains more water given the same width) to move towards the other side.
Keep a running max and return it when the two bars meet.
*/
func maxArea(height []int) int {
    l, r, max:= 0, len(height)-1, 0
    
    for l < r {
        w := r - l
        h := height[r]
        if height[l] < height[r] {
            h = height[l]
            l++
        }else{
            r--
        }
        
        water := w * h
        if water > max {
            max = water
        }
    }
    
    return max
}
