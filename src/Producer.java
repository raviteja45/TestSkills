package com.example.demo;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	BlockingQueue<Integer> bq;
	public Producer(BlockingQueue<Integer> bq){
		this.bq = bq;
		
	}
	@Override
	public void run() {
		for(int i=1;i<=4;i++) {
			System.out.println("Produced "+i);
			bq.add(i);
		}
	}
}
