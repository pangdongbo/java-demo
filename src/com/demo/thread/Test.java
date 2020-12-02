package com.demo.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: 庞东博
 * @create: 2020-11-26 19:33
 **/
public class Test {

	public static void main(String[] args) {
		ConcurrentHashMap map = new ConcurrentHashMap();
		map.put("a", "null");
		map.put("b", "null");
		System.out.println(1 << 1);
	}

}
