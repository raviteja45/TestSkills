package com.home.hashing;

public class Custom {

	Node_customHashMap[] all = new Node_customHashMap[10];
	public void put(int key,int val) {
		
		int keyValue = generateKey(key);
		if(all.length>keyValue) {
			if(all[keyValue]!=null) {
				Node_customHashMap n = all[keyValue];
				while(n.getNext()!=null) {
					n = n.getNext();
				}
				Node_customHashMap n1 = new Node_customHashMap();
				n1.setKey(key);
				n1.setValue(val);
				n.setNext(n1);
			}
			else {
				Node_customHashMap n = new Node_customHashMap();
				n.setKey(key);
				n.setValue(val);
				all[keyValue] = n;
			}
		}
	}
	
	public void get(int key) {
		int keyValue = generateKey(key);
		if(all[keyValue]!=null) {
			Node_customHashMap n = all[keyValue];
			while(n.getKey()!=key) {
				n = n.getNext();
			}
			if(n.getKey()==key) {
				System.out.println("Value is "+n.getValue());
			}
		}
		else {
			System.out.println(" Not value found");
		}
	}

	private int generateKey(int key) {
		int res = key*32;
		int keyValue = res%10;
		return keyValue;
		
	}

}
