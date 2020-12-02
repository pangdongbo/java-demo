package com.demo.thread.sync;

/**
 * 一个说明synchronized是可重入锁的示例
 * 重入锁：只有获得了锁，在释放锁前可以多次进入被锁的代码块
 */
public class ReentryDemo {

	/**
	 * 记录进入次数
	 */
	private static int entryCount = 0;

	public static void main(String[] args) {

		// A多次进入了entry方法
		new Thread(new Runnable() {
			@Override
			public void run() {
				entry();
			}
		}, "A").start();

		// B一次也进入不了
		new Thread(new Runnable() {
			@Override
			public void run() {
				entry();
			}
		}, "B").start();
	}

	private static synchronized void entry() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (10 == entryCount) {
			return ;
		}
		System.out.println(Thread.currentThread().getName() + " entry " + entryCount++);
		entry();
	}

}
