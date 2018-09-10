package array;

/**
 * @author Administrator
 *	ʹ�÷��ͣ���������ʹ�õ����ͣ�
 * @param <E>
 */
public class Array<E> {
	
	private E[] data;//Ԫ���ݣ���ʼʱint��
	/**
	 * ����ʵ�ʱ�������ݸ�����Ҳ��ʾ������û��Ԫ�ؿ�ʼ��λ�ã���������
	 */
	private int size;
	/**
	 * ���췽������ʼ�����������
	 * @param capacity
	 */
	public Array(int capacity){
		data=(E[])new Object[capacity];//Java�﷨����ֱ��newһ�����͵����飬��new E[10]
		size=0;
	}
	
	/**
	 * �޲ι��췽������ʼ������Ϊ10��
	 */
	public Array(){
		this(10);
	}
	/**
	 * ��ȡ�����е�Ԫ�ظ�����
	 */
	public int getSize(){
		return size;
	}
	/**
	 * ��ȡ�����������
	 */
	public int getCapacity(){
		return data.length;
	}
	/**
	 * ����Ԫ���Ƿ�Ϊ�գ�
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * ����������㣬ֱ�������ĩβ
	 * ���������㣬�׳��쳣
	 */
	public void addLast(E e){
//		if(size==data.length)
//			throw new IllegalArgumentException("AddLast failed. Array is full.");
//		data[size]=e;//��ӽ�ĩβ
//		size++;//ά��ʵ�ʵ�����Ԫ�ظ�����
		add(size,e);//ֱ�Ӹ�����ӵ��Զ�λ�þͿ���ʵ�֣�
	}
	public void addFirst(E e){
		add(0,e);//��ӽ���һ��Ԫ�أ�
	}
	/**
	 * ָ�������������ݣ�
	 */
	public void add(int index,E e){
		//�±겻�Ϸ��׳��쳣
		if(index<0||index>size)//�±�С��0�����ߴ�����ʵ�ʵ�����Ԫ�ظ�����
			throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
		//����Ԫ�س���������������
		if(size==data.length)
			resize((size*2));//����ArrayList�Ǿ�����+(������>>1)����
		
		for(int i=size-1;i>=index;i--){
			data[i+1]=data[i];//�������������Ų��
		}
		data[index]=e;
		size++;//ʵ�ʳ���ά����
	}
	//˽������
	private void resize(int newCapacity) {
		E[] newData=(E[]) new Object[newCapacity];
		for(int i=0;i<size;i++){
			newData[i]=data[i];
		}
		data=newData;//��������ָ��ԭ���飻
		newData=null;
	}

	/**
	 * �����±��ȡ����Ԫ��
	 * �����û���ѯû��ʵ��Ԫ�صĿռ���ʣ�
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
	 * �ж��������Ƿ���ĳ��Ԫ��
	 */
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e))//ʹ�÷��ͺ�˴�����ʹ��==
				return true;
		}
		return false;
	}
	/**
	 * ����Ԫ�����ڵ��±꣬û�з���-1��
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
	 * ɾ��ָ��������Ԫ�أ������ظ�Ԫ��****(�ؼ��±�)
	 * ��������removeFirst��last�ȷ��������ô˷������У�
	 */
	public E remove(int index){
		if(index<0||index>=size)
			throw new IllegalArgumentException("Remove failed. Index is illegal.");
		E ret=data[index];
		for(int i=index+1;i<size;i++){
			data[i-1]=data[i];
			//��ָ���±꿪ʼ��Ԫ������ǰŲ����ֵ���������int�����һ��Ԫ�ز��ùܣ���Ϊsizeλ���û��޷����ʣ�
			//���ʹ�÷��ͣ����һ��Ԫ�ر�����һ�����ã��Զ������������޷������Ҫ�����ͷŵ�
		}
		size--;//sizeά����
		data[size]=null;//�����ͷ�ĩβԪ�ص����ã�ʹ֮���Զ����յ���
		
		//���ʵ��Ԫ�ظ���С����������һ�㣬����������С,�ҳ��Ȳ���Ϊ0��
		if(size<data.length/4&&data.length/2!=0)
			resize(data.length/2);//����������С�������˷ѣ�
		return ret;
	}
	/**
	 * ɾ��ָ��Ԫ�أ���һ��������ɾ���ظ��ģ�
	 */
	public void removeElement(E e){
		int index = find(e);
		if(index!=-1)
			remove(index);
	}
	@Override
	public String toString(){//����Object�ķ�������ʾ��ӡ����Ľ����
		StringBuilder res=new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", size,data.length));
		res.append('[');
		for(int i=0;i<size;i++){
			res.append(data[i]);
			if(i!=size-1){
				res.append("��");
			}
		}
		res.append(']');
		return res.toString();
	}
}
