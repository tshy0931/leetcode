/**
Kind of like an Inorder traversal.
1. create a stack to hold TreeNode's that we'll return later.
2. in constructor, go from root node all the way to the leftmost leaf node, 
   and push each of them onto stack. Just like an inorder traversal.
3. Every time next() is called, we pop one TreeNode from the stack and will return its value. 
   But before that we check, if it has right child node, say rChild, 
   then we go from rChild all the way down to the leftmost leaf node under rChild, 
   and push each of the nodes onto the stack.
4. there's no more next node only when the stack is empty, hence the simple hasNext() implementation.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class BSTIterator {

    private Stack stack = null;
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack();
        TreeNode p = root;
        while(p!=null){
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = (TreeNode) stack.pop();
        TreeNode p = next.right;
        while(p!=null){
            stack.push(p);
            p = p.left;
        }
        return next.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
