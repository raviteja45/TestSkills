// First class

package com.playground.printnumberstwothreads;

public class Print20In2Threads {
	
	public static void main(String[] args) {
		Object lock = new Object();
		Onethread one = new Onethread(lock);
		Thread t1 = new Thread(one);
		Thread t2 = new Thread(one);
		t1.start();
		t2.start();	
	}
}


// Second class

package com.playground.printnumberstwothreads;

public class Onethread implements Runnable{
    
	static int count = 1;
	Object lock = null;
	
	Onethread(Object lock){
		this.lock = lock;
	}
 
    @Override
    public void run() {
    	while(count<=20) {
    		synchronized(lock) {
    			System.out.println(count+"-"+Thread.currentThread().getName());
    			count++;
    			lock.notify();
    			if(count<=20) {
    				try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}
        
    }
}
