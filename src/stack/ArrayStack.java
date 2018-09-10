package stack;

import array.Array;
public class ArrayStack<E> implements Stack<E> {
	private Array<E> array;//基于动态数组实现；
	public ArrayStack(int capacity){
		array=new Array<>(capacity);
	}
	public ArrayStack(){
		array=new Array<>();
	}
	/**
	 * 只是针对动态数组实现栈专有的方法，所以不能加入接口中；
	 */
	public int getCapacity(){
		return array.getCapacity();
	}
	@Override
	public int getSize() {
		return array.getSize();
	}
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	/* 往栈顶添加元素
	 */
	@Override
	public void push(E e) {
		array.addLast(e);
	}
	/* 取出栈顶元素（取出后就不在了，所以应该是remove，而不是get）；
	 */
	@Override
	public E pop() {
		return array.removeLast();
	}
	/* 
	 * 看一下栈顶元素；
	 */
	@Override
	public E peek() {
		return array.getLast();
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("ArrayStack：[");
		for(int i=0;i<array.getSize();i++){
			res.append(array.get(i));
			if(i!=array.getSize()-1)
				res.append("，");
		}
		res.append("] top");
		return res.toString();
	}
}
