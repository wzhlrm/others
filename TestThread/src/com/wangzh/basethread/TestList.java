package com.wangzh.basethread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestList {
	public static void main(String[] args) {
		Collection<User> userlist = new ArrayList<User>();
		userlist.add(new User("zhangsan", 21));
		userlist.add(new User("lisi",22));
		Iterator<User> it = userlist.iterator();
		while (it.hasNext()){
			System.out.println(it.next().toString());
		}
	}

}
