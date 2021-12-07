class Solution {
   public List<List<Integer>> combinationSum(int[] cands, int t) {
        Arrays.sort(cands);
       List<List<List<Integer>>> result = new ArrayList<>();
        for(int i=1;i<=t;i++){
            List<List<Integer>> temp = new ArrayList<>();
            for(int j=0;j<cands.length&&cands[j]<=i;j++){
                if(i==cands[j]){
                    temp.add(Arrays.asList(cands[j]));
                }else{
                    for(List<Integer>l:result.get(i-cands[j]-1)){
                        if(cands[j]<=l.get(0)){
                            List<Integer> cl = new ArrayList<>();
                            cl.add(cands[j]);
                            cl.addAll(l);
                            temp.add(cl);
                        }
                        
                    }
                }
            }
            result.add(temp);
        }
       return result.get(t-1);
    }
}


V2-----
   
class Solution {
   public List<List<Integer>> combinationSum(int[] cands, int t) {
       List<List<Integer>> result = new ArrayList<>();
       backTracking(result,0,cands,t,new ArrayList<>());
       return result;
    }
    public void backTracking(List<List<Integer>> result, int start, int[] cands, int target, List<Integer> temp){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(temp));
        }
        for(int i=start;i<cands.length;i++){
            temp.add(cands[i]);
            backTracking(result,i,cands,target-cands[i],temp);
            temp.remove(temp.size()-1);
        }
        
    }
}

/**
39. Combination Sum
Medium

7697

185

Add to List

Share
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
*/
