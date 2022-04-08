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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) 
            return null;
        Queue<TreeNode[]> q = new LinkedList<>(); 
        TreeNode r = new TreeNode();
        q.add(new TreeNode[]{t1,t2,r}); 
        while(!q.isEmpty()) {
            TreeNode[] t = q.poll();
            if(t[0]==null&&t[1]==null){
                break;
            }
            t[2].val = (t[0]!=null?t[0].val:0)+(t[1]!=null?t[1].val:0);
            if((t[0]!=null&&t[0].right!=null)||(t[1]!=null&&t[1].right!=null)){
                  q.add(new TreeNode[]{t[0]!=null?t[0].right:null, t[1]!=null?t[1].right:null, t[2].right = new TreeNode()});
            }
  if((t[0]!=null&&t[0].left!=null)||(t[1]!=null&&t[1].left!=null)){
      q.add(new TreeNode[]{t[0]!=null?t[0].left:null, t[1]!=null?t[1].left:null, t[2].left = new TreeNode()});
  }
            
       
        }
        return r;
    }
}


/**
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
Example 2:

Input: root1 = [1], root2 = [1,2]
Output: [2,2]
*/
