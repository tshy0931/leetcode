/*
Topological Sort

BFS:
build adjacency list from the prerequisites list.
Find the courses with no prereqs and put into result list.
Then for each of these starter courses, "remove" it from the graph by decreasing inDegree of all its adjacent courses.
If any adjacent course has no more prerequisites after the removal (inDegree == 0), add it to result list.

if there's no available starter courses (inDegree == 0) but still courses not processed yet, that means there's a cycle in the graph and not possible to do a topological sort, hence returning empty list.

otherwise return the result list.
*/
func findOrder(numCourses int, prerequisites [][]int) []int {
    
    queue := make([]int, 0, numCourses)
    inDegree := make([]int, numCourses, numCourses)
    graph := make(map[int][]int)
    
    for _, edge := range prerequisites {
        from, to := edge[1], edge[0]
        inDegree[to]++
        graph[from] = append(graph[from], to)
    }
    
    for i, n := range inDegree {
        if n == 0 {
            queue = append(queue, i)
        }
    }

    for i := 0; i < numCourses; i++ {
        if i >= len(queue) { // no course with no prereq but not all courses are processed yet. must have a cycle in the graph.
            return []int{}
        }
        course := queue[i]
        nextCourses := graph[course]

        for _, next := range nextCourses {
            inDegree[next]--
            if inDegree[next] == 0 { // this course has no prereq now, add to queue
                queue = append(queue, next)
            }
        }
    }
    
    return queue
}
