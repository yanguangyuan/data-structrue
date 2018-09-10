package Queue;

public class Main {

	public static void main(String[] args) {
		ArrayQueue<Integer> aq=new ArrayQueue<>();
		for(int i=0;i<5;i++){
			aq.enqueue(i);
			System.out.println(aq);
		}
		System.out.println(aq.dequeue());
		System.out.println(aq);
	}

}
