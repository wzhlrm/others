package com.wangzh.basethread;

public class TestThread {
	public static void main(String[] args){
		Calc c = new Calc();
		MyThread t1 = new MyThread(c);
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.m2();		
	}
}
class MyThread extends Thread{
	Calc c = null;
	public MyThread(Calc c){
		this.c = c;
	}
	@Override
	public void run() {
		c.m1();
	}

}
class Calc{
	int b=500;
	public synchronized void m1(){
		b=1000;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1:b="+b);
	}
	public void m2(){
		System.out.println("m2:b="+b);
	}
}
