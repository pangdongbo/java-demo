package com.demo.datastruct.linked;

/**
 * @description: 带头单向链表
 * @author: 庞东博
 * @create: 2020-12-01 19:44
 **/
public class SinglyLinkedList implements IList {

	public static void main(String[] args) {
		// 创建链表
		IList list = new SinglyLinkedList();
		// 向链表添加10个值
		for (int i = 0; i < 10; i++) {
			list.add(new Node("" + i));
		}
		System.out.println(list.getSize());
		list.forEach();
		// 获取第10个节点的值
		System.out.println(list.get(list.getSize() - 1).value);
		list.add(list.getSize(), new Node("("+ list.getSize() +")"));
		list.forEach();
		list.remove(list.getSize() - 1);
		list.forEach();
		list.add(list.getSize() - 1, new Node("(" + list.getSize() + ")"));
		list.forEach();
		System.out.println(list.get(list.getSize() - 1).value);
		list.reverse();
		list.forEach();
	}

	/**
	 * 链表中的节点数量
	 */
	private int size;

	/**
	 * 第一个节点
	 */
	private Node first;

	@Override
	public void add(Node node) {
		int size = this.getSize();
		if (0 == size) {
			this.first = node;
		} else {
			Node last = this.get(size - 1);
			last.next = node;
		}
		this.size++;
	}

	@Override
	public void add(int i, Node node) {
		this.validateIndex(i);
		if (0 == i) {
			if (null == first) {
				first = node;
			} else {
				node.next = first;
				first = node;
			}
		} else {
			Node pre = this.get(i - 1);
			if (null != pre) {
				node.next = pre.next;
				pre.next = node;
			} else {
				throw new RuntimeException("插入链表异常，游标越界了。");
			}
		}
		this.size++;
	}

	@Override
	public boolean remove(int i) {
		this.validateIndex(i);
		boolean result = true;
		if (i == 0) {
			if (null != first) {
				first = first.next;
			} else {
				result = false;
			}
		} else if (i > this.getSize() - 1) {
			result = false;
		} else {
			Node pre = this.get(i - 1);
			pre.next = pre.next.next;
		}
		this.size--;
		return result;
	}

	@Override
	public Node get(int i) {
		this.validateIndex(i);
		int count = 0;
		Node target = null;
		Node currNode = this.first;
		while (null != currNode) {
			if (count++ == i) {
				target = currNode;
				break;
			}
			currNode = currNode.next;
		}
		return target;
	}

	@Override
	public void forEach() {
		Node currNode = this.first;
		while (null != currNode) {
			System.out.print(currNode.value);
			currNode = currNode.next;
		}
		System.out.println("");
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void reverse() {
		if (0 != this.size) {
			if (1 == this.size) {
				System.out.print(this.first.value);
			} else {
				for (int i = this.size - 1; i > 1; i--) {
					Node swapFirst = this.first; // 交换第一个节点
					Node swapLast = this.get(i); // 交换前的最后一个节点
					this.first = this.first.next; // 把第二个节点移动到第一个节点
					if (i == this.size - 1) {
						swapFirst.next = null; // 如果是第一个交换，则他是最后一个节点，所有该节点.next = null;
					} else {
						swapFirst.next = swapLast.next; // 交换过来后，next
					}
					swapLast.next = swapFirst;  // 把第一个节点移动到最后
				}
			}
		}
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