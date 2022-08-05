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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    
    public int helper(TreeNode temp, int sum){
        if(temp==null){
            return 0;
        }
        if(temp!=null){
            sum = sum*10+temp.val;
        }
        if(temp.left==null&&temp.right==null){
            return sum;
        }
        return helper(temp.left,sum)+helper(temp.right,sum);
    }
}

----------------------------v2--------------------------------
    
class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        iterativePreOrder(root);
        return total;
    }
    
    public void iterativePreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> valStack = new Stack<>();
        valStack.push(root.val);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            int curr = valStack.pop();
            if(temp.right==null&&temp.left==null){
                total = total+curr;
            }
            
            if(temp.right!=null){
                stack.push(temp.right);
                valStack.push(curr*10+temp.right.val);
            }
            if(temp.left!=null){
                stack.push(temp.left);
                valStack.push(curr*10+temp.left.val);
            }
        }
    }
}

/**
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

*/
