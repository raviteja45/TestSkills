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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
       Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Queue<Integer> val = new LinkedList<>();
        val.add(root.val);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode t = q.poll();
                System.out.println(t.val);
                int x = val.poll();
                System.out.println("X is "+x);
                if(t.left==null&&t.right==null&&x==targetSum){
                    return true;
                }
                if(t.left!=null){
                    q.add(t.left);
                    val.add(t.left.val+x);
                }
                if(t.right!=null){
                    q.add(t.right);
                    val.add(t.right.val+x);
                }
            }
        }
        return false;
    }
}

--------------------------------V2-------------------------------
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
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        helper(root,targetSum,0);
        return res;
    }
    
    public void helper(TreeNode root, int target,int sum){
        if(root==null){
            return;
        }
        sum = sum+root.val;
       if(root.left==null&&root.right==null&&sum==target){
            res = true;
            return;
        }
        helper(root.left,target,sum);
        helper(root.right,target,sum);
        
    }
}

/**
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

*/
