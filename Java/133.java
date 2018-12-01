/**
Recursive:
Clone a node and recursively clone its neighbors.
To handle cyclic graph, for each node we only clone once and put in a map to reuse.

DFS:
Use a stack to store unhandled nodes.
Make copy of the first node, reference it as return value.
Push to stack and clone each of its neighbor nodes only if the neighbor is not handled yet,
and add the copied neighbor to the neighbor list of the copied node.
Pop a node from stack and repeat the steps above until stack is empty.

BFS:
Use a queue to store unhandled nodes, enqueue root node.
repeatedly, dequeue a node, clone and enqueue its neighbor nodes only if not handled yet,
and add the copied neighbor to the neighbor list of the copied node.
Stop when queue is empty.

 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    private Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // return recursive(node);
        // return dfs(node);
        return bfs(node);
    }

    private UndirectedGraphNode recursive(UndirectedGraphNode node) {
        if(node == null) return null;
        if(visited.containsKey(node.label)){
            return visited.get(node.label);
        }
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        visited.put(copy.label, copy);

        for(UndirectedGraphNode n : node.neighbors){
            copy.neighbors.add(recursive(n));
        }
        
        return copy;
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if(node == null) return null;
        
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        
        nodes.put(node.label, new UndirectedGraphNode(node.label));
        UndirectedGraphNode root = nodes.get(node.label);
        
        while(!stack.isEmpty()){
            UndirectedGraphNode n = stack.pop();
            UndirectedGraphNode copy = nodes.get(n.label);
            
            for(UndirectedGraphNode neighbor : n.neighbors) {
                if(!nodes.containsKey(neighbor.label)){
                    stack.push(neighbor);
                    nodes.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                copy.neighbors.add(nodes.get(neighbor.label));
            }
        }
        
        return root;
    }
    
    private UndirectedGraphNode bfs(UndirectedGraphNode node) {
        if(node == null) return null;
        
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        
        nodes.put(node.label, new UndirectedGraphNode(node.label));
        UndirectedGraphNode root = nodes.get(node.label);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            UndirectedGraphNode copy = nodes.get(n.label);
            
            for(UndirectedGraphNode neighbor : n.neighbors) {
                if(!nodes.containsKey(neighbor.label)){
                    queue.offer(neighbor);
                    nodes.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                copy.neighbors.add(nodes.get(neighbor.label));
            }
        }
        
        return root;
    }
}
