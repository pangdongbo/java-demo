package com.demo.thread.pool;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.*;

public class ThreadPoolDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 3000, TimeUnit.MILLISECONDS, queue);
		Future<String> callable = executor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "callable";
			}
		});
		System.out.println(callable.get());

		executor.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("runnable");
			}

		});

	}

}
