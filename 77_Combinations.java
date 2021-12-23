class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result,n,k,1,new ArrayList<>());
        return result;
    }
    public void backTracking(List<List<Integer>>res,int n,int k,int index,List<Integer> temp){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=index;i<=n;i++){
                temp.add(i);
                backTracking(res,n,k,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}


/**
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]

*/
