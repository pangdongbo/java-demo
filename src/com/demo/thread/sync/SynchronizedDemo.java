package com.demo.thread.sync;

import java.util.concurrent.CountDownLatch;

/**
 * 一个wait和Notify的示例
 */
public class SynchronizedDemo {

	private static Integer num = 0;

	private static CountDownLatch latch = new CountDownLatch(1000);

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (num) {
						num++;
					}
					latch.countDown();
				}
			}).start();
		}

		while (true) {
			if (0 == latch.getCount()) {
				System.out.println(num);
				break;
			}
		}

	}

}
