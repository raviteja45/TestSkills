class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getAllElements(root,list);
       return createBST(list,0,list.size()-1);
    }
    
    public void getAllElements(TreeNode root,List<Integer> li){
        if(root==null){
            return;
        }
        getAllElements(root.left,li);
        li.add(root.val);
        getAllElements(root.right,li);
    }
    
    public TreeNode createBST(List<Integer> list, int low, int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode t = new TreeNode(list.get(mid));
        t.left = createBST(list,low,mid-1);
        t.right = createBST(list,mid+1,high);
        return t;
    }
}


/**
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]

*/
