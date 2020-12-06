package com.demo.algorithm.sort;

/**
 * @description: 插入排序
 * @author: 庞东博
 * @create: 2020-12-04 21:50
 **/
public class Insert {

	public static void main(String[] args) {
		//int[] number = {10,9,8,7,6,5,4,3,2,1};
		//int[] number = {1,2,3,4,5,6,7,8,9,10};
		int[] number = {1,8,3,8,9,7,10,5,2,8};
		for (int i = 1; i < number.length; i++) {
			int temp = number[i];
			for (int j = i - 1; j >= 0 ; j--) {
				if (number[j] > temp) {
					number[j + 1] = number[j];
					number[j] = temp;
				} else {
					number[j + 1] = temp;
					break;
				}
			}
		}

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + "，");
		}
	}

}
