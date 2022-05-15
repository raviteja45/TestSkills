package com.flink.example.demo;

import java.util.ArrayList;
import java.util.List;

public class HeapDs {

	public void heapify(List<Integer> arr, int i) {
		int size = arr.size();
		int largest = i;
		int left = 2 * i + 1;// returns left position of the element present at i
		int right = 2 * i + 2;// returns right position of the element present at i;
		if (left < size && arr.get(left) > arr.get(largest)) {
			largest = left;
		}
		if (right < size && arr.get(right) > arr.get(largest)) {
			largest = right;
		}
		if (i != largest) {
			int temp = arr.get(largest);
			arr.set(largest, arr.get(i));
			arr.set(i, temp);
			heapify(arr, largest);

		}

	}

	public void insert(List<Integer> arr, int element) {
		int size = arr.size();
		if (arr.size() == 0) {
			arr.add(element);
		} else {
			arr.add(element);
			for (int i = size / 2 - 1; i >= 0; i--) { // size/2-1 will return the last leaf element
				heapify(arr, i);
			}
		}
	}
	
	public void delete(List<Integer> arr, int element) {
		int i = 0;
		int size = arr.size();
		for( i=0;i<arr.size();i++) {
			if(arr.get(i)==element) {
				break;
			}
		}
		int temp = arr.get(i);
		arr.set(i, arr.get(arr.size()-1));//Replace the element that needs to be deleted with the last element present in array, place the element that needs to be deleted at last
		arr.set(size-1, temp);
		arr.remove(size-1);
		for(int j = size/2-1;j>=0;j--) {
			heapify(arr,j);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		HeapDs heapDs = new HeapDs();
		heapDs.insert(arr, 5);
		heapDs.insert(arr, 7);
		heapDs.insert(arr, 9);
		heapDs.insert(arr, 1);
		System.out.println(arr); // 9 7 5 1
		heapDs.delete(arr, 7);
		System.out.println(arr); // 9 1 5
		heapDs.delete(arr, 9);
		System.out.println(arr); // 5 1
		
		
	}

}
