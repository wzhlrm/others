package com.wangzh.basethread;

public class TestJoin {
	public static void main(String[] args) {
		MyThread3 myThread3 = new MyThread3("thread1");
		myThread3.start();
		
		for (int i = 0; i < 10; i++)
			System.out.println("I am Main Thread");
		
		try {
			myThread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
