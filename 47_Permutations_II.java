class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result,nums,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }
    public void backTracking(List<List<Integer>>res,int[]nums,List<Integer> temp, boolean[]used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i]) 
                    continue;
            if(i>0 &&nums[i]==nums[i-1] && !used[i-1]) 
                continue;
                used[i] = true;
                temp.add(nums[i]);
                backTracking(res,nums,temp,used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
