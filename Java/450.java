/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        TreeNode parent = null, child = root;
        
        while(child!=null){
            if(key == child.val){
                // found the node to delete
                if(child.left == null && child.right == null){ // node to delete has no subtree
                    if(parent == null) return null; // deleting root node
                    if(child == parent.left) parent.left = null;
                    else parent.right = null;
                    return root;
                }
                if(child.left == null || child.right == null){ // node to delete has one subtree
                    TreeNode grandChild = child.left == null ? child.right : child.left;
                    if(parent == null) return grandChild; // deleting root node
                    if(child == parent.left) {
                        parent.left = grandChild;
                    } else {
                        parent.right = grandChild;
                    }
                    return root;
                }
                // node to delete has two subtrees
                TreeNode succ = child.right, succParent = child;
                while(succ.left != null) {
                    succParent = succ;
                    succ = succ.left; // find the successor (the leftmost node in the right subtree)
                }
                if(succParent == child){ // the right child is successor
                    if(parent == null){ // deleting root node
                        succ.left = root.left;
                        return succ;
                    }
                    succ.left = child.left;
                    if(child == parent.left){    
                        parent.left = succ;
                    } else {
                        parent.right = succ;
                    }
                }else{
                    succParent.left = succ.right; // attach successor's right subtree to its place
                    succ.left = child.left;
                    succ.right = child.right;
                    if(parent == null){ // deleting root node
                        return succ;
                    }

                    if(child == parent.left){    
                        parent.left = succ;
                    } else {
                        parent.right = succ;
                    }
                }
                
                return root;
                
            } else {
                parent = child;
                child = key < parent.val ? parent.left : parent.right;
            }
        }
        return root; // given key doesn't exist in the BST
    }
}
