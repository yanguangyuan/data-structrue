package stack;

public class Main {

	public static void main(String[] args) {
		ArrayStack<Integer> as=new ArrayStack<>();
		for(int i=0;i<5;i++){
			as.push(i);
			System.out.println(as);
		}
		as.pop();
		System.out.println(as);
		System.out.println(as.peek());
		
	}

}
