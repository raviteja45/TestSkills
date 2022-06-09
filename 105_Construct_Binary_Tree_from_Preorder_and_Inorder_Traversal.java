class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode curr = root;
        stack.push(root);
        int j=0;
        for(int i=1;i<preorder.length;i++){ 
            if(inorder[j]!=curr.val){ // Push until we see last left element.
                TreeNode temp = new TreeNode(preorder[i]);
                curr.left = temp;
                stack.push(curr);
                curr = curr.left;
            }else{
                j++;
                while(!stack.isEmpty()&&stack.peek().val==inorder[j]){
                    curr = stack.pop();// All left elements piled up. Take all of them until we 
                                       // see main root.
                    j++;
                }
                TreeNode t1 = new TreeNode(preorder[i]); // once we have root, add right.
                curr.right = t1;
                curr = curr.right;
            }
        }
        return root;
        //Preorder - root - left- right. InOrder - Left - root - right.
    }
}


/**
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
*/
