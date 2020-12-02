package com.demo.thread.sync;

/**
 * 锁住对象的demo
 */
public class SynchronizedObjectDemo {

	public static void main(String[] args) {
		SynchronizedObjectDemo objLock1 = new SynchronizedObjectDemo();
		SynchronizedObjectDemo objLock2 = new SynchronizedObjectDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {
				objLock1.test();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				objLock2.test();
			}
		}).start();
	}

	/**
	 *
	 */
	private synchronized void test() {
		System.out.println("进入a方法");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("a方法结束");
	}



}
