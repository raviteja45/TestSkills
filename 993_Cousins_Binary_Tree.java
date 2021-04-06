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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> second = new HashMap<>();
        int counter = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode t = q.poll();
                first.put(t.val,counter);
                if(t.left!=null){
                    q.add(t.left);
                    second.put(t.left.val,t.val);
                }
                if(t.right!=null){
                    q.add(t.right);
                    second.put(t.right.val,t.val);
                }
            }
            counter = counter+1;
        }
        if(first.containsKey(x)&&first.containsKey(y)&&first.get(x)==first.get(y)){
            if(second.get(x)!=second.get(y)){
                return true;
            }
        }
        return false;
    }
}

/**
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
*/
