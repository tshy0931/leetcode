/*
BFS
Idea is to one-by-one remove nodes that have no incoming edge, also remove its outgoing edgs at the same time.
If a node has no incoming edge left during the removal, put it into the queue of candidates to do the removal later.
Stop removal if there's no node with no incoming edge. 
If there's a cycle in the graph, there must still be node(s) not removed yet.
*/
func canFinish(numCourses int, prerequisites [][]int) bool {
    if numCourses <= 0 {
        return false
    }
    if prerequisites == nil || len(prerequisites) == 0 {
        return true
    }
    
    inDegrees := make([]int, numCourses, numCourses)
    adjList := make([][]int, numCourses)
    queue := make([]int, 0, numCourses)
    removed := 0
    
    for _, edge := range prerequisites {
        to, from := edge[0], edge[1]
        if from == to {
            return false
        }
        inDegrees[to]++
        adjList[from] = append(adjList[from], to)
    }
    
    for i, n := range inDegrees {
        if n == 0 {
            queue = append(queue, i)
            removed++
        }
    }
    
    for len(queue) > 0 {
        n := queue[0]
        for _, out := range adjList[n] {
            inDegrees[out]--
            if inDegrees[out] == 0 {
                queue = append(queue, out)
                removed++
            }
        }
        if len(queue) <= 1 {
            break
        }
        queue = queue[1:]
    }
    
    return removed == numCourses
}

/*
DFS
1. use two maps to keep nodes visited and visiting
2. for each node that is not visited, walk all possible paths and return false if there's a circle in the path (a visiting node is being visited more than once).
3. return true if all paths are walked and no circle was found.
*/
// func canFinish(numCourses int, prerequisites [][]int) bool {
//     if numCourses <= 0 {
//         return false
//     }
//     if prerequisites == nil || len(prerequisites) == 0 {
//         return true
//     }
    
//     inDegrees := make([]int, numCourses, numCourses)
//     adjList := make([][]int, numCourses, numCourses)
//     used, done := make(map[int]bool), make(map[int]bool)
    
//     for i:=0; i<numCourses; i++ {
//         adjList[i] = make([]int, 0, numCourses)
//     }
    
//     for _, edge := range prerequisites {
//         to, from := edge[0], edge[1]
//         if from == to {
//             return false
//         }
//         nextNodes := adjList[from]
//         inDegrees[to]++
//         adjList[from] = append(nextNodes, to)
//     }
    
//     for i:=0; i<numCourses; i++ {
//         if !done[i] {
//             if hasCycle(i, used, done, adjList) {
//                 return false
//             }
//         }
//     }
//     return true
// }

// func hasCycle(nowAt int, used map[int]bool, done map[int]bool, adjList [][]int) bool {
//     if used[nowAt] == true {
//         return true
//     }
//     used[nowAt] = true
//     nextNodes := adjList[nowAt]
//     for _, n := range nextNodes {
//         if hasCycle(n, used, done, adjList) {
//             return true
//         }
//     }    
//     used[nowAt] = false
//     done[nowAt] = true
//     return false
// }
