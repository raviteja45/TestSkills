package com.example.demo;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort merge = new MergeSort();
		int[] nums = {3,6,1,6,7,5,4,9};
		int[] result = merge.mergeSort(0,nums.length-1,nums);
		for(int n:result) {
			System.out.print(n);
		}
		

	}
	
	public int[] mergeSort(int low, int high, int[] nums) {
		if(low==high) {
			int[] br = new int[1];
			br[0] = nums[low];
			return br;
		}
		int mid = low+(high-low)/2;
		int[]first_half = mergeSort(low,mid,nums);
		int[]second_half = mergeSort(mid+1,high,nums);
		int[] merged = mergeSortHelper(first_half,second_half);
		return merged;
		
		
	}
	
	public int[] mergeSortHelper(int[] one, int[] two) {
		int[] sorted = new int[one.length+two.length];
		int i=0,j=0,k=0;
		while(i<one.length&&j<two.length) {
			if(one[i]>two[j]) {
				sorted[k] = two[j];
				k++;
				j++;
			}else {
				sorted[k] = one[i];
				k++;
				i++;
			}
		}
		if(i==one.length) {
			while(j<two.length) {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}
		if(j==two.length) {
			while(i<one.length) {
				sorted[k] = one[i];
				k++;
				i++;
			}
		}
		return sorted;
	}

}
