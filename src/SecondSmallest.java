public int secondSmall(int[] nums) {
		 int small = nums[0];
		 for(int i=0;i<nums.length;i++) {
			 if(nums[i]<small) {
				 small = nums[i];
			 }
		 }
		 int smallest = nums[0];
		 for(int i=0;i<nums.length;i++) {
			 if(smallest>nums[i]&&nums[i]!=small) {
				 smallest = nums[i];
			 }
		 }
		 return smallest;
	 }
