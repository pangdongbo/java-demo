package com.demo.algorithm.sort;

import com.sun.org.apache.xpath.internal.objects.XNumber;

/**
 * @description: 冒泡排序算法
 * @author: 庞东博
 * @create: 2020-12-04 12:37
 **/
public class Bubbling {

	public static void main(String[] args) {
		//int[] number = {10,9,8,7,6,8,4,3,2,1};
		//int[] number = {1,2,3,4,5,6,7,8,9,10};
		int[] number = {1,8,3,4,9,7,10,5,2,6};
		int count = 0;
		for (; count < number.length;) {
			count++;
			boolean flag = false; // 哨兵
			for (int j = 0; j < number.length - count; j++) {
				if (number[j] > number[j + 1]) {
					int temp = number[j + 1];
					number[j + 1] = number[j];
					number[j] = temp;
					flag = true;
				}
			}
			if (!flag) { // 如果检测到数据没有交换，则说明排序结束，退出循环；
				break;
			}
		}

		System.out.println("在第" + count + "次循环结束排序。");

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + "，");
		}
	}

}
