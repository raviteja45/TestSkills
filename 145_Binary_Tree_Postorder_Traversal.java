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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res_recursive = new ArrayList<>();
        LinkedList<Integer> res_iterative = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return new ArrayList<>();
        }
        stack.push(root);
      //  postOrder(root,res);
        stackBased(root,stack,res_iterative);
        return res_iterative;
    }
    
    public void postOrder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
    
    public void stackBased(TreeNode root, Stack<TreeNode> stack, LinkedList<Integer> res){
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.addFirst(temp.val);
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        
    }
}


/**
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
*/
