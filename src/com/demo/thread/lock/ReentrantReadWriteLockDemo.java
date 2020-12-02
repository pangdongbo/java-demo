package com.demo.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入读写锁的示例
 */
public class ReentrantReadWriteLockDemo {

	private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

	private static Integer num = 0;

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				write();
			}
		}, "write").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int result = read();
				System.out.println(result);
			}
		}, "read").start();
	}

	/**
	 * 写数据
	 * @return
	 */
	private static int write() {
		rwLock.writeLock().lock();
		try {
			Thread.sleep(3000);
			num++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rwLock.writeLock().unlock();
		return num;
	}

	/**
	 * 读数据
	 * @return
	 */
	private static int read() {
		rwLock.writeLock().lock();
		int result = num;
		rwLock.writeLock().unlock();
		return result;
	}

}
