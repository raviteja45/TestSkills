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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,TreeNode> map = new HashMap<>();
        stack.push(root);
        map.put(root,null);
        while(!map.containsKey(p)||!map.containsKey(q)){
            TreeNode temp = stack.pop();
            if(temp.left!=null){
                map.put(temp.left,temp);
                stack.push(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right,temp);
                stack.push(temp.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = map.get(p);
        }
        while(!ancestors.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}


/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
*/
