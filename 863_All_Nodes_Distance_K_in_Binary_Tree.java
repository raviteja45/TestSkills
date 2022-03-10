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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map= new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        Set<TreeNode> vis= new HashSet<>();
        q.add(root);
        while(!q.isEmpty()){
            int h = q.size();
            for(int i=0;i<h;i++){
                TreeNode cur= q.poll();
            if (cur==target) 
                break;
            if (cur.left!=null){
                map.put(cur.left, cur);
                q.add(cur.left);
            }
            if (cur.right!=null){
                map.put(cur.right, cur);
                q.add(cur.right);
            }
            }
            
        }
        q.clear();
        q.add(target);
        vis.add(target);
        while(K>0){ 
            int nm = q.size();
            for (int sz=0; sz<nm; sz++){
                TreeNode cur=q.poll();
                if (cur.left!=null && vis.add(cur.left)){
                    q.add(cur.left);
                } 
                if (cur.right!=null && vis.add(cur.right)){
                    q.add(cur.right);
                } 
                if (map.get(cur)!=null && vis.add(map.get(cur))){
                    q.add(map.get(cur));
                } 
            }
            K--;
        }
        List<Integer> res= new LinkedList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        } 
        return res;
    }
}

/**
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []

*/
