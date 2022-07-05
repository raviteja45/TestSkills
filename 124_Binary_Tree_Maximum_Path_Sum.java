class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return result;
    }
    
    public int pathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,pathSum(root.left));
        int right = Math.max(0,pathSum(root.right));
       //The below two statements will be called once the left 
       //and right is null @ 9 in second example.
       // The recursive calls keep checking until its at leaf nodes, then starts below lines
        result = Math.max(result,left+right+root.val);
        return Math.max(left,right)+root.val;
       
    }
}


/**
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
*/
