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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode k = q.poll();
                if(k.val>=low&&k.val<=high){
                    res = res+k.val;
                }
                if(k.left!=null)
                    q.add(k.left);
                if(k.right!=null)
                    q.add(k.right);
            }
        }
        return res;
        
    }
}

//Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
