public boolean pairTriplets(String num) {
    	int[] nums = new int[10];
    	for(int i=0;i<num.length();i++) {
    		nums[num.charAt(i)-'0']++;
    	}
    	boolean isPair = false;
    	for(int i=0;i<10;i++) {
    		nums[i] = nums[i]%3;
    		if(nums[i]==2) {
    			isPair = true;
    		}else if((isPair&&nums[i]==2)||nums[i]==1) {
    			return false;
    		}
    		
    		
    	}
    	return isPair;
}

/**
give a string with only numbers, find if string is complete.
complete means: should have exactly one pair, and zero or more triplets. Pair is a number occuring only once, and triplets means occuring thrice. Order does not matter, only freq.
e.g. 44888, 44444, 44999999, 46767674 , 88-> TRUE
4455666, 889, 889997, 9078907 -> FALSE
*/
