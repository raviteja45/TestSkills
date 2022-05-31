package com.example.demo;

public class Testing {

	public static void main(String[] args) {
		int[] nums = {4,7,8,40,400,600,610,780};
		search(nums,4);
	}
	
	public static void search(int[] nums,int search) {
		int low = 0;
		int high = nums.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(nums[mid]==search) {
				System.out.println("Found");
				return;
			}else {
				if(search<nums[mid]) {
					high = mid-1;
				}else {
					low = mid+1;
				}
			}
			
		}
		System.out.println("Nothing found");
	}

}
