class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,List<Integer>> treeMap = new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int n = q.size();
            Map<Integer,List<Integer>> levelMap = new HashMap<>();
            for(int i=0;i<n;i++){
                Pair temp = q.poll();
                int distance = temp.hd;
                List<Integer> temp1 = levelMap.getOrDefault(distance,new ArrayList<>());
                temp1.add(temp.node.val);
                Collections.sort(temp1);
                levelMap.put(distance,temp1);
                if(temp.node.left!=null){
                    q.add(new Pair(distance-1,temp.node.left));
                }
                if(temp.node.right!=null){
                    q.add(new Pair(distance+1,temp.node.right));
                }
                
            }
            for(Map.Entry<Integer,List<Integer>> temp2:levelMap.entrySet()){
                List<Integer> temp3 = treeMap.getOrDefault(temp2.getKey(),new ArrayList<>());
                temp3.addAll(temp2.getValue());
                treeMap.put(temp2.getKey(),temp3);
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}

class Pair{
    int hd;
    TreeNode node;
    Pair(int hd, TreeNode node){
        this.hd = hd;
        this.node = node;
    }
}


/**
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
*/
