/*
Dynamic Programming

Build an array to store min cost of each stair i, which can be derived from min costs of stairs before i.

    min[i] = math.Min(min[i-1], min[i-2]) + cost[i]
*/
func minCostClimbingStairs(cost []int) int {
    leng := len(cost)
    min := make([]int, leng)
    min[0] = cost[0]
    min[1] = cost[1]
    
    for i := 2; i<leng; i++ {
        if min[i-1] < min[i-2] {
            min[i] = cost[i] + min[i-1]
        } else {
            min[i] = cost[i] + min[i-2]
        }
    }
    if min[leng-1] < min[leng-2] {
        return min[leng-1]
    } else {
        return min[leng-2]
    }
}
