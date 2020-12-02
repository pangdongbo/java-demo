package com.demo.datastruct.linked;

/**
 * @description:
 * @author: 庞东博
 * @create: 2020-12-01 19:40
 **/
public interface IList {

	/**
	 * 添加一个节点
	 * @param node
	 * @return
	 */
	void add(Node node);

	/**
	 * 在指定的位置插入节点
	 * @param i
	 * @param node
	 * @return
	 */
	void add(int i, Node node);

	/**
	 * 删除一个节点
	 * @param i
	 * @return
	 */
	boolean remove(int i);

	/**
	 * 获取指定位置的节点
	 * @param i
	 * @return
	 */
	Node get(int i);

	/**
	 * 遍历所有节点
	 */
	void forEach();

	/**
	 * 链表的总数量
	 * @return
	 */
	int getSize();


}
