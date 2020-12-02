package com.demo.thread.sync;

/**
 * 一个饿汉的单例模式
 * 使用双重检查防止重复创建
 * 使用volatile防止指令重排序防止重复创建
 */
public class SingletonDemo {

	private volatile static SingletonDemo instance = null;

	private SingletonDemo() {}

	public SingletonDemo getInstance() {
		if (null == instance) {
			synchronized (instance) {
				if (null == instance) {
					instance = new SingletonDemo();
				}
			}
		}
		return instance;
	}

}
