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
    public String getDirections(TreeNode root, int startValue, int destValue) {
       TreeNode ancestor =  getCommonAncestor(root,startValue,destValue); // same as 236. LCA 
       String v = getPath(ancestor, startValue);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length(); i++)
            sb.append("U"); // From startValue to UP (until ancestor)
        String u = getPath(ancestor, destValue);
        
        return sb.toString() + u;
    }
    
    public TreeNode getCommonAncestor(TreeNode root, int start, int dest){
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root,null);
        TreeNode[] arr = new TreeNode[2];
        findNodes(root,start,dest,arr);
        while(!map.containsKey(arr[0])||!map.containsKey(arr[1])){
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
        Set<TreeNode> set = new HashSet<>();
        TreeNode first = arr[0];
        TreeNode sec = arr[1];
        while(first!=null){
            set.add(first);
            first = map.get(first);
        }
        while(!set.contains(sec)){
            sec = map.get(sec);
        }
        return sec;
    }
    
    public void findNodes(TreeNode root,int startVal,int endVal,TreeNode[] arr){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                if(temp.val == startVal){
                    arr[0] = temp;
                }
                if(temp.val==endVal){
                    arr[1] = temp;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }
    
    private String getPath(TreeNode ancestor, int value) {
        Map<Integer, int[]> from = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(ancestor);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++){
                 TreeNode curr = queue.poll();
            if (curr.val == value)
                break;
            if (curr.left != null) {
                from.put(curr.left.val, new int[]{curr.val, 1});
                queue.add(curr.left);
            }
            if (curr.right != null) {
                from.put(curr.right.val, new int[]{curr.val, 2});
                queue.add(curr.right);
            } 
            }
           
        }
        StringBuilder sb = new StringBuilder();
        while (value != ancestor.val) {
            String direction = from.get(value)[1] == 1 ? "L" : "R";
            sb.append(direction);
            value = from.get(value)[0];
        }
        
        return sb.reverse().toString();
    }
}


/**
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 

Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
*/
