package com.wangzh.basethread;
public class MyThread3 extends Thread {

	MyThread3(String s) {
		super(s);
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("I am " + getName());
			try {
				sleep(1000); // ��ͣ��ÿһ�����һ��
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}