class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
                TreeNode temp = stack.pop();
                if(temp.right!=null){
                    stack.add(temp.right);
                }
                if(temp.left!=null){
                    stack.add(temp.left);
                }
            if(!stack.isEmpty()){
                temp.right = stack.peek();
            }
            temp.left = null;
        }
    }
}
