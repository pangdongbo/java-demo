package com.demo.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入锁的基本使用
 */
public class ReentrantLockDemo {

	private static ReentrantLock rlock = new ReentrantLock();

	private static Integer num = 0;

	private static CountDownLatch cdl = new CountDownLatch(1000);

	public static void main(String[] args) {

		for(int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					rlock.lock();
					num++;
					rlock.unlock();
					cdl.countDown();
				}
			}).start();
		}

		while (true) {
			if (0 == cdl.getCount()) {
				System.out.println(num);
				break;
			}
		}
	}

}
