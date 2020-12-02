package com.demo.thread.sync;

/**
 * 锁住对象的demo
 */
public class SynchronizedClassDemo {

	public static void main(String[] args) {

		SynchronizedClassDemo objLock1 = new SynchronizedClassDemo();
		SynchronizedClassDemo objLock2 = new SynchronizedClassDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (SynchronizedClassDemo.class) {
					objLock1.test();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (SynchronizedClassDemo.class) {
					objLock2.test();
				}
			}
		}).start();
	}

	/**
	 *
	 */
	private void test() {
		System.out.println("进入a方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("a方法结束");
	}



}
