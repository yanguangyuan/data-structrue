package stack;



import org.junit.Test;

public class SolutionTest {

	

	@Test
	public void testIsValid() {
		Solution s=new Solution();
		String str="([]){}";
		boolean b=s.isValid(str);
		System.out.println(b);
		
	}

}
