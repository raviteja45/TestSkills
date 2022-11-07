package com.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AllTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(4);
		Producer p1 = new Producer(bq);
		Consumer c1 = new Consumer(bq);
		Thread t1 = new Thread(p1);
		t1.start();
		Thread t2 = new Thread(c1);
		t2.start();
  }
}

Produced 1
Produced 2
Produced 3
Consumed 1
Consumed 2
Consumed 3
Produced 4
Consumed 4
