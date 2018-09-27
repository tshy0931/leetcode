/**
Recursive:
At each node n,
a) if n is p or q, just return n. 
Because if the other target node is in subtree of n, then n is the lowest common ancestor.
Otherwise, some node upper in the tree will be the lowest common ancestor, which will be found later in recursion.

b) if n is neither p or q, resursively find subtree at n.left and n.right.
If both targets are found in left and right subtrees, n is the lowest common ancestor.
Otherwise, return whichever node we found, or null if none.

The current node root is ancestor of p and q if

1) root is ancestor of p AND root is ancestor of q
2) root is p AND root is ancestor of q
3) root is q AND root is ancestor of p

-----------------------
Iterative:
Use a map to keep all ancestors of p and q, where key is a node in the ancestor chain and value is parent of the node in key.
Given that p and q both will exist in the tree, the LCA must be one of the ancestors of p.
Then traverse the ancestor chain of q, the first node existing in map of p's ancestors is the LCA.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return find(root, p, q);
        if(root == null) return null;
        
        TreeNode lca = root;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        parentMap.put(root, null);
        
        while(!stack.isEmpty() && (!parentMap.containsKey(p) || !parentMap.containsKey(q))){
            TreeNode n = stack.pop();
            if(n.left != null) {
                parentMap.put(n.left, n);
                stack.push(n.left);
            }
            if(n.right != null) {
                parentMap.put(n.right, n);
                stack.push(n.right);
            }
        }
        
        Set<TreeNode> ancestorsP = new HashSet<>();
        
        for(TreeNode p0 = p; p0 != null; p0 = parentMap.get(p0)) {
            ancestorsP.add(p0);
        }
        
        for(TreeNode q0 = q; q0 != null; q0 = parentMap.get(q0)) {
            if(ancestorsP.contains(q0)){
                return q0;
            }
        }
        return null;
    }
    
    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;
        
        TreeNode l = find(root.left, p, q);
        TreeNode r = find(root.right, p, q);
        if(l != null && r != null) return root;
        return l == null ? r : l;
    }
}
