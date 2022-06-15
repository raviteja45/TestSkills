class Solution { // Time limit exceed.
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
       int sum=0;
	    for(int i=0;i<nums.length;i++){
	        sum+=nums[i];
	    }
	    if(sum%k!=0){
            return false;
        } 
	    return canPartition(0,nums,new boolean[nums.length],0,sum/k,k);
    }
    
    public void backTracking(int[] nums, int target, List<List<Integer>> res, int index, List<Integer> temp){
        if(target<0){ // Just example 
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(temp));
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            backTracking(nums,target-nums[i],res,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
    
public boolean canPartition(int start,int[] nums,boolean[] seen,int currSum,int targetSum,int k) {
        if(k==1)
            return true;
        if(currSum==targetSum){
            return canPartition(0,nums,seen,0,targetSum,k-1);
        }
        for(int i=start;i<nums.length;i++){
            if(!seen[i]){
                seen[i]=true;
                if(canPartition(i+1,nums,seen,currSum+nums[i],targetSum,k))
                    return true;
                seen[i]=false;
            }
        }
        return false;
    }
}
