package com.wangzh.basethread;

import java.util.List;

public class HelloThread extends Thread {
	String threadName;
	List<String> list;
	
	public HelloThread(String threadName,List<String> list) {
		this.threadName = threadName;
		this.list = list;
	}

	public void run() {
		for (int i=0;i<100;i++){
			try {
				//Thread.sleep(10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//synchronized(list)
			{
				list.add(this.threadName+" of  " + i);
				System.out.println(this.threadName + "  list count:  " + list.size());
			}

		}
	}

}
