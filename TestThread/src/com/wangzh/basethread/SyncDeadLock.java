package com.wangzh.basethread;

public class SyncDeadLock {
	private static Object locka = new Object();
	private static Object lockb = new Object();
    public static void main(String[] args){  
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (locka) {
						System.out.println(Thread.currentThread().getName() + " 锁定 locka!");
						System.out.println(Thread.currentThread().getName()+" 等待 lockb!");  
						synchronized (lockb) {
							System.out.println(Thread.currentThread().getName()	+ " 锁定 lockb!");
						}
				}
			}
		}, "thread1");

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lockb) {
					System.out.println(Thread.currentThread().getName() + " 锁定 lockb!");
					System.out.println(Thread.currentThread().getName()+" 等待 locka!");  
					synchronized (locka) {
						System.out.println(Thread.currentThread().getName()	+ " 锁定 locka!");
					}
				}
			}
		}, "thread2");
		
        thread1.start();  
        thread2.start(); 
    } 
}
