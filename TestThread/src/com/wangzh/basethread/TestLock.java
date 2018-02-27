package com.wangzh.basethread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	public static void main(String[] args){
		final Outputter outer = new Outputter();
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				while (true){
					outer.output("wangzhihua");
					if (outer.stop)
						break;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {
				while (true){
					outer.output("liruimin");
					try {
						Thread.sleep(100);
						if (outer.stop)
							break;						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
		});
		t1.start();
		t2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outer.stop=true;
	}
	static class Outputter{
		public boolean stop = false;
		Lock lock = new ReentrantLock();
		public void output(String str){
			lock.lock();
			//**************************************
				int len=str.length();
				for (int i=0;i<len;i++){
					System.out.print(str.charAt(i));
				}
				System.out.println();
			//****************************************
			lock.unlock();
		}
	}
}
