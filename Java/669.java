/**
1. Find correct root.
if root is already greater than R, the correct root must be in its left subtree, so move root to its left child node.
if root is already less than L, the correct root must be in its right subtree, so move root to its right child node.
Repeat above until root value is within [L, R].

2. prune nodes with value less than L
use a pointer to track parent node while traversing. Starting from root node.
if current node value > L, go to its left child node
if current node value < L, we have to prune current node by replacing it with its right child, and go to that node.
if current node value = L, set current node's left node to null (prune left subtree) and stop traversing.

3. prune nodes with value greater than R
use a pointer to track parent node while traversing. Starting from root node.
if current node value < R, go to its right child node
if current node value > R, we have to prune current node by replacing it with its left child, and go to that node.
if current node value = R, set current node's right node to null (prune right subtree) and stop traversing.

4. return the updated root node.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        while(root.val < L || root.val > R){
            if(root == null) return null;
            if(root.val < L) root = root.right; 
            if(root.val > R) root = root.left;
        }
        
        TreeNode l = root, r = root, parent = root;
        while(l != null) {
            if(l.val > L) {
                parent = l;
                l = l.left;
            } else if(l.val == L) {
                l.left = null;
                break;
            } else {
                parent.left = l.right;
                l = l.right;
            }
        }
        
        while(r != null) {
            if(r.val < R) {
                parent = r;
                r = r.right;
            } else if(r.val == R) {
                r.right = null;
                break;
            } else {
                parent.right = r.left;
                r = r.left;
            }
        }
        
        return root;
    }
}
