package com.demo.thread.unsafe;

import java.util.concurrent.CountDownLatch;

/**
 * 一个线程不安全的示例：使用10线程对全局变量num进行自增
 * 期望的结果是：100000，实际结果都小于100000
 */
public class UnsafeDemo {

	private volatile static int num;

	private static CountDownLatch latch = new CountDownLatch(10);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {

				for (int j = 0; j < 10000; j++) {
					num++;
				}

				latch.countDown();

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
