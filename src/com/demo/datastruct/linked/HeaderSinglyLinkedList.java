package com.demo.datastruct.linked;

/**
 * @description: 带头单向链表
 * @author: 庞东博
 * @create: 2020-12-01 19:44
 **/
public class HeaderSinglyLinkedList implements IList {

	public static void main(String[] args) {
		// 创建链表
		IList list = new HeaderSinglyLinkedList();
		// 向链表添加10个值
		for (int i = 0; i < 10; i++) {
			list.add(new Node("" + i));
		}
		System.out.println(list.getSize());
		list.forEach();
		// 获取第10个节点的值
		System.out.println(list.get(9).value);
		list.add(9, new Node("(9)"));
		list.forEach();
		list.remove(9);
		list.forEach();
		System.out.println("==" + list.getSize());
		list.add(9, new Node("(9)"));
		list.forEach();
	}

	/**
	 * 链表中的节点数量
	 */
	private int size;

	/**
	 * 带头节点
	 */
	private Node header;

	/**
	 * 第一个节点
	 */
	private Node first;

	public HeaderSinglyLinkedList() {
		header = new Node(null);
		header.next = first;
	}

	@Override
	public void add(Node node) {

	}

	@Override
	public void add(int i, Node node) {

	}

	@Override
	public boolean remove(int i) {

		return true;
	}

	@Override
	public Node get(int i) {

		return null;
	}

	@Override
	public void forEach() {

		System.out.println("");
	}

	@Override
	public int getSize() {
		return this.size;
	}

	/**
	 * 检查游标位置是否大于等于0，如果小于0则抛出异常
	 * @param i
	 */
	private void validateIndex(int i) {
		if (i < 0) {
			throw new RuntimeException("输入错误的位置，位置标符应该大于0，输入的位置是：" + i);
		}
	}

}
