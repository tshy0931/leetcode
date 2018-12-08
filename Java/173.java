/**
In-order traversal provides the nodes in acending order.
Max space usage is max tree height.
And on average the next() method takes constant time.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        for(TreeNode p = root; p != null; p = p.left){
            stack.push(p);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = stack.pop();
        for(TreeNode q=n.right; q!=null; q=q.left){
            stack.push(q);
        }
        return n.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
