/**
Post-order traversal tells us which is the root node at a subtree,
In-order traversal tells us which nodes are in left/right subtree of the node.

So starting with both inorder/postorder index range [0, len-1],
the last postorder element in the range is root node of this subtree.
Then find out the position i of that element in corresponding inorder range.
elems before i in inorder array are in left subtree, and the ones after i are in right subtree.
Recursively process left and right until leaf node.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return subtreeAt(0, inorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    private TreeNode subtreeAt(int inl, int inr, int postl, int postr, int[] inorder, int[] postorder) {
        if(inl > inr || postl > postr) return null;
        TreeNode root = new TreeNode(postorder[postr]);
        for(int i=inl; i<=inr; i++) {
            if(inorder[i] == root.val) {
                int leftcount = i - inl;
                root.left = subtreeAt(inl, i-1, postl, postl+leftcount-1, inorder, postorder);
                root.right = subtreeAt(i+1, inr, postl+leftcount, postr-1, inorder, postorder);
                return root;
            }
        }
        return root;
    }
}
