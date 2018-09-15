/**
Use FIFO queue to achieve level-order traversal. Enqueue the root node.
While the queue is not empty, dequeue a node each time,
add its value to the list of current level, and enqueue its child nodes.
To identify when a level has been fully processed, use a TreeNode reference, 'last', to point to the last node of current level.
When we finished processing the node referenced by 'last', update 'last' to point to the last element in the queue.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return result;
        TreeNode last = root;
        queue.offerLast(root);
        
        while(!queue.isEmpty()) {
            TreeNode n = queue.pollFirst();
            level.add(n.val);
            if(n.left != null) queue.offerLast(n.left);
            if(n.right != null) queue.offerLast(n.right);
            if(n == last) {
                last = queue.peekLast();
                result.add(level);
                level = new ArrayList<>();
            }
        }
        return result;
    }
}
