package com.demo.thread.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				String desc = "I am A";
				System.out.println(Thread.currentThread().getName() + "：" + desc);
				try {
					String newDesc = exchanger.exchange(desc);
					System.out.println(Thread.currentThread().getName() + "：" + newDesc);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				String desc = "I am B";
				System.out.println(Thread.currentThread().getName() + "：" + desc);
				try {
					String newDesc = exchanger.exchange(desc);
					System.out.println(Thread.currentThread().getName() + "：" + newDesc);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "B").start();
	}

}