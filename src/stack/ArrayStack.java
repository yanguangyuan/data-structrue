package stack;

import array.Array;
public class ArrayStack<E> implements Stack<E> {
	private Array<E> array;//���ڶ�̬����ʵ�֣�
	public ArrayStack(int capacity){
		array=new Array<>(capacity);
	}
	public ArrayStack(){
		array=new Array<>();
	}
	/**
	 * ֻ����Զ�̬����ʵ��ջר�еķ��������Բ��ܼ���ӿ��У�
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
	/* ��ջ�����Ԫ��
	 */
	@Override
	public void push(E e) {
		array.addLast(e);
	}
	/* ȡ��ջ��Ԫ�أ�ȡ����Ͳ����ˣ�����Ӧ����remove��������get����
	 */
	@Override
	public E pop() {
		return array.removeLast();
	}
	/* 
	 * ��һ��ջ��Ԫ�أ�
	 */
	@Override
	public E peek() {
		return array.getLast();
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("ArrayStack��[");
		for(int i=0;i<array.getSize();i++){
			res.append(array.get(i));
			if(i!=array.getSize()-1)
				res.append("��");
		}
		res.append("] top");
		return res.toString();
	}
}
