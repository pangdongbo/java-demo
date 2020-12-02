package com.demo.thread.datastruct.linked;

/**
 * @description:
 * @author: 庞东博
 * @create: 2020-12-01 19:41
 **/
public class Node {

	/**
	 * 节点的值
	 */
	protected String value;

	/**
	 * 下一个节点
	 */
	protected Node next;

	protected Node(String value) {
		this.value = value;
	}

}
