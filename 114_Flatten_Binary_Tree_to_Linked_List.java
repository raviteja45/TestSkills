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

-----------------------------V2 ------------------------------------
    
class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){ // We are first creating pre-order traversal
            TreeNode temp = stack.pop();
            if(temp!=null)
            q.add(temp); // Now elements are in pre-order traversal
            if(temp.right!=null)
            stack.push(temp.right);
            if(temp.left!=null)
            stack.push(temp.left);
        }
        root = q.poll();
        root.left = null; // First take the root and make left as null.
        TreeNode temp1 = root;
        while(!q.isEmpty()){
            TreeNode k = q.poll(); // Next node
            k.left = null; // Make the node left is null
            temp1.right = k; // Assign to root right side
            temp1 = k; // jumping to next node
        }
    }
}
