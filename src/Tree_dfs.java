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
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        dfs(root,s);
        return -1;
    }
    
    public void dfs(TreeNode root,Stack<TreeNode> stack){
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }
}




class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return -1;
    }
    
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }
}
