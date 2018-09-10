package array;

/**
 * @author Administrator
 *	使用泛型，声明数组使用的类型；
 * @param <E>
 */
public class Array<E> {
	
	private E[] data;//元数据；初始时int型
	/**
	 * 数组实际保存的数据个数，也表示数组中没有元素开始的位置（索引）；
	 */
	private int size;
	/**
	 * 构造方法，初始化数组的容量
	 * @param capacity
	 */
	public Array(int capacity){
		data=(E[])new Object[capacity];//Java语法不能直接new一个泛型的数组，即new E[10]
		size=0;
	}
	
	/**
	 * 无参构造方法，初始化容量为10；
	 */
	public Array(){
		this(10);
	}
	/**
	 * 获取数组中的元素个数；
	 */
	public int getSize(){
		return size;
	}
	/**
	 * 获取数组的容量；
	 */
	public int getCapacity(){
		return data.length;
	}
	/**
	 * 数组元素是否为空；
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * 如果容量满足，直接添加在末尾
	 * 容量不满足，抛出异常
	 */
	public void addLast(E e){
//		if(size==data.length)
//			throw new IllegalArgumentException("AddLast failed. Array is full.");
//		data[size]=e;//添加进末尾
//		size++;//维护实际的数组元素个数；
		add(size,e);//直接复用添加到自定位置就可以实现；
	}
	public void addFirst(E e){
		add(0,e);//添加进第一个元素；
	}
	/**
	 * 指定索引插入数据；
	 */
	public void add(int index,E e){
		//下标不合法抛出异常
		if(index<0||index>size)//下标小于0，或者大于了实际的数组元素个数；
			throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
		//数组元素充满容器进行扩容
		if(size==data.length)
			resize((size*2));//现在ArrayList是旧容量+(旧容量>>1)左移
		
		for(int i=size-1;i>=index;i--){
			data[i+1]=data[i];//从最后依次往后挪；
		}
		data[index]=e;
		size++;//实际长度维护；
	}
	//私有扩容
	private void resize(int newCapacity) {
		E[] newData=(E[]) new Object[newCapacity];
		for(int i=0;i<size;i++){
			newData[i]=data[i];
		}
		data=newData;//将新数组指回原数组；
		newData=null;
	}

	/**
	 * 根据下标获取数据元素
	 * 限制用户查询没有实际元素的空间访问；
	 */
	public E get(int index){
		if(index<0||index>=size)
			throw new IllegalArgumentException("Get failed. Index is illegal.");
		return data[index];
	}
	public void set(int index,E e){
		if(index<0||index>=size)
			throw new IllegalArgumentException("Set failed. Index is illegal.");
		data[index]=e;
	}
	public E getLast(){
		return get(size-1);
	}
	public E getFirst(){
		return get(0);
	}
	/**
	 * 判断数组中是否含有某个元素
	 */
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e))//使用泛型后此处不能使用==
				return true;
		}
		return false;
	}
	/**
	 * 查找元素所在的下标，没有返回-1；
	 */
	public int find(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}
	public E removeLast(){
		return remove(size-1);
	}
	public E removeFirst(){
		return remove(0);
	}
	/**
	 * 删除指定索引的元素，并返回该元素****(关键下标)
	 * 可以增加removeFirst，last等方法，复用此方法就行；
	 */
	public E remove(int index){
		if(index<0||index>=size)
			throw new IllegalArgumentException("Remove failed. Index is illegal.");
		E ret=data[index];
		for(int i=index+1;i<size;i++){
			data[i-1]=data[i];
			//从指定下标开始，元素依次前挪（赋值），如果是int型最后一个元素不用管，因为size位置用户无法访问；
			//如果使用泛型，最后一个元素保存了一个引用，自动的垃圾回收无法到达，需要主动释放掉
		}
		size--;//size维护；
		data[size]=null;//主动释放末尾元素的引用；使之被自动回收掉；
		
		//如果实际元素个数小于了容量的一般，进行容量缩小,且长度不能为0；
		if(size<data.length/4&&data.length/2!=0)
			resize(data.length/2);//进行容器缩小，避免浪费；
		return ret;
	}
	/**
	 * 删除指定元素（第一个，不会删除重复的）
	 */
	public void removeElement(E e){
		int index = find(e);
		if(index!=-1)
			remove(index);
	}
	@Override
	public String toString(){//覆盖Object的方法，表示打印输出的结果；
		StringBuilder res=new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", size,data.length));
		res.append('[');
		for(int i=0;i<size;i++){
			res.append(data[i]);
			if(i!=size-1){
				res.append("，");
			}
		}
		res.append(']');
		return res.toString();
	}
}
