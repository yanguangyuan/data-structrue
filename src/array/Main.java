package array;

public class Main {

	public static void main(String[] args) {
		Array<Integer> arr = new Array<>();//1.7开始后面的泛型不用写，只需写<>
		for(int i=0;i<10;i++)
			arr.addLast(i);
		System.out.println(arr);
		arr.add(2, 100);
		System.out.println(arr);
		arr.addFirst(-1);
		System.out.println(arr);
	}

}
