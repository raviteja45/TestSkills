package com.flink.example.demo;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQ {

	public static void main(String[] args) {
		//Queue<Bean> q = new PriorityQueue<>((t1,t2)->t2.getName().compareTo(t1.getName())); //[Bean [name=Zpp, sal=500], Bean [name=Best, sal=5000], Bean [name=Test, sal=3000]]
		Queue<BeanPriorityQ> q = new PriorityQueue<>((t1,t2)->t1.getName().compareTo(t2.getName())); //[Bean [name=Best, sal=5000], Bean [name=Test, sal=3000], Bean [name=Zpp, sal=500]]
		BeanPriorityQ b1 = new BeanPriorityQ();
		b1.setName("Test");
		b1.setSal(3000);
		q.add(b1);
		BeanPriorityQ b2 = new BeanPriorityQ();
		b2.setName("Best");
		b2.setSal(5000);
		q.add(b2);
		BeanPriorityQ b3 = new BeanPriorityQ();
		b3.setName("Zpp");
		b3.setSal(500);
		q.add(b3);
		System.out.println(q);
		System.out.println(q.peek());//returns top element without deleting it
		System.out.println(q.poll()); // returns top element and delete the element from Queue
		
	}

}
