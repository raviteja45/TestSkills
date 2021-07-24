/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
       Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int counter = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode t1 = q.poll();
                if(t1.left==null&&t1.right==null){
                    return counter ;
                }
                if(t1.left!=null){
                    t.add(t1.left);
                }
                if(t1.right!=null){
                    t.add(t1.right);
                }
            }
            counter = counter+1;
        }
        return counter;
    }
}




/**

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


*/
