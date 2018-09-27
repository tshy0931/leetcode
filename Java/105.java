/**
pre-order indicates where the root node of this subtree is,
in-order indicates which nodes belongs to left/right subtree of the root.

So recursively, root node is the first elem in preorder in given range.
Then find how many nodes are in left subtree by checking the root value in given inorder range.
Recursively process left/right subtrees.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subTree(0, inorder.length, 0, preorder.length, preorder, inorder);
    }
    
    private TreeNode subTree(int inl, int inr, int prel, int prer, int[] preorder, int[] inorder) {
        if(prel >= prer) return null;
        TreeNode root = new TreeNode(preorder[prel]);
        for(int i=inl; i<inr; i++) {
            if(inorder[i] == root.val) {
                int leftcount = i - inl;
                root.left = subTree(inl, i, prel+1, prel+leftcount+1, preorder, inorder);
                root.right = subTree(i+1, inr, prel+1+leftcount, prer, preorder, inorder);
                return root;
            }
        }
        return root;
    }
}
