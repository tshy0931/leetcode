/*
Iterative:
Use a HashMap<Node, Boolean> to store status of nodes we have visited. 
Store false if it has been visited but its children nodes are not done processing yet.
Store true if all its children nodes are done and it's time to process itself.

Use a stack and push root initially.
while the stack is not empty, which means not all nodes have been processed yet,
check the status of current node on top of stack, 
a) if it's false, do not pop it, just push it's children onto the stack and add their status as false.
set its status to true and continue next loop.
b) if it's true, that means all its children nodes have been processed. Pop it from stack and process it.

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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Map<Node, Boolean> status = new HashMap<>();
        status.put(root, false);
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        
        while(!stack.isEmpty()){
            Node n = stack.peekFirst();
            if(true == status.get(n)){
                res.add(n.val);
                stack.removeFirst();
            } else {
                status.put(n, true);
                int leng = n.children.size();
                for(int i = leng-1; i >= 0; --i){
                    stack.offerFirst(n.children.get(i));
                    status.put(n.children.get(i), false);
                }
            }
        }
        return res;
    }
}
