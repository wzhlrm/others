package com.wangzh.basethread;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class BaseThreadTest {
	public static void main(String[] args) {

	}
	@Test
	public void testThread() {
		final Object obj=new Object();
		Thread t1 = new Thread(){
			public void run(){
				synchronized(obj){
					System.out.println("T1 started!");
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("T1 end!");
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				synchronized(obj){
					System.out.println("T2 started!");
					obj.notify();
					System.out.println("T2 end!");
				}
			}
		};		
		t1.start();
		t2.start();
	}
}
