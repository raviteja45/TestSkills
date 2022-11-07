package com.example.demo;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> bq;

	Consumer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}
	
	int taken = 0;

	@Override
	public void run() {
		while (taken!=5) {
			try {
				taken = bq.take();
				System.out.println("Consumed " + taken);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
