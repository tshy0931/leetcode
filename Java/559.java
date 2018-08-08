/*
DFS:
Recursive:
Traverse the tree and return maximum depth at each subtree, then return max depth among all child subtrees.

Iterative:
Use a FILO stack to traverse tree iteratively while keeping track of maximum depth seen.
Might need to store nodes with corresponding depth.

BFS:
Iterative:
Use a FIFO queue to traverse tree at level-order and increment depth when starting a new level. return the depth after traversal.

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return bfs(root);
        // return dfs(root, 1);
    }
    
    private int dfs(Node root, int depth) {
        if(root == null) return depth-1;
        int max = depth, curr = depth;
        for(Node child : root.children) {
            curr = dfs(child, depth+1);
            max = curr > max ? curr : max;
        }
        return max;
    }
    
    private int bfs(Node root) {
        if(root == null) return 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        int depth = 1;
        Node last = root;
        
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();
            for(Node child : n.children){
                queue.offerLast(child);
            }
            if(last == n){
                if(queue.isEmpty()) {
                    return depth;
                } else {
                    last = queue.peekLast();
                    depth++;
                }
            }
        }
        return depth;
    }
}
