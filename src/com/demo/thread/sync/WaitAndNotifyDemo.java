package com.demo.thread.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * 停水了，主人急着用水，所以把水龙头开着，当水来了就会有声音通知主要，主人再把水龙头关了
 */
public class WaitAndNotifyDemo {

	private static Object lock = new Object();

	public static void main(String[] args) throws Exception {
		// 开始加水了
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 模拟等水来
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock) {
					System.out.println("水龙头：哗啦哗啦哗啦");
					lock.notifyAll();
				}
			}
		}).start();

		// 等待关水
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						System.out.println("主人：先把水龙头开着");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("主人：水终于来了！");
				}
			}
		}).start();

	}

}
