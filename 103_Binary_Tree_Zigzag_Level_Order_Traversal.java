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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode t = q.poll();
                temp.add(t.val);
                    if(t.left!=null){
                        q.add(t.left);
                    }
                    if(t.right!=null){
                        q.add(t.right);
                    }
            }
            if(count%2!=0){
                Collections.reverse(temp);
                result.add(temp);
            }else{
                result.add(temp);
            }
            count = count+1;
        }
        return result;
    }
}


/**
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


*/
