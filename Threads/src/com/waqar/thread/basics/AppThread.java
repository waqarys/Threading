package com.waqar.thread.basics;

class RunnerThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Hello "+ i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class AppThread {

	public static void main(String[] args) {
		RunnerThread runner1 = new RunnerThread();
		runner1.start();
		
		RunnerThread runner2 = new RunnerThread();
		runner2.start();
	}
}
