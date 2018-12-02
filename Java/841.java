/*
Recursive DFS:
Use a set to track rooms that have been visited.
Starting from room 0, add 0 to the visited set, for each key in room 0, 
if the key is not visited yet, add the key to visited and recursively visit keys in that room,
otherwise do not visit the room again.
We can visit all rooms only when the size of visited set equals to the size of the rooms.

Iterative BFS:
Use a queue to keep the keys we found in a room, only enqueue the keys not visited yet.
Repeat until the queue is empty, and check if size of visited set equals size of rooms.
*/
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return false;
        Set<Integer> visited = new HashSet<>();
        visitBFS(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
    
    private void visitDFS(List<List<Integer>> rooms, Integer i, Set<Integer> visited) {
        if(visited.contains(i)) return;
        visited.add(i);
        for(Integer key : rooms.get(i)) {
            visitDFS(rooms, key, visited);
        }
    }
    
    private void visitBFS(List<List<Integer>> rooms, Integer i, Set<Integer> visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        while(!queue.isEmpty()){
            Integer key = queue.poll();
            visited.add(key);
            for(Integer k : rooms.get(key)){
                if(!visited.contains(k)){
                    queue.offer(k);
                }
            }
        }
    }
}
