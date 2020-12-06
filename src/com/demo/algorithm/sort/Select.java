package com.demo.algorithm.sort;

/**
 * @description: 选择排序
 * @author: 庞东博
 * @create: 2020-12-06 21:47
 **/
public class Select {

	public static void main(String[] args) {
		int[] number = {10,9,8,7,6,5,4,3,2,1};
		//int[] number = {1,2,3,4,5,6,7,8,9,10};
		//int[] number = {1,8,3,8,9,7,10,5,2,8};

		for (int i = 0; i < number.length; i++) {
			int minIndex = i;
			int min = number[i];
			for (int j = i + 1; j < number.length; j++) { // 在未排序区间选出最小的值
				if (number[j] < min) {
					min = number[j];
					minIndex = j;
				}
			}
			if (minIndex != i) { // 把未排区间的最小值和以排序区间的最后一个值交换
				int temp = number[i];
				number[i] = number[minIndex];
				number[minIndex] = temp;
			}
		}
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + "，");
		}
	}

}
