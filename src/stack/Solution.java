package stack;
import java.util.Stack;
public class Solution {
	public boolean isValid(String s) {
		char c=0;
		Stack<Character> as = new Stack<>();
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c=='('||c=='{'||c=='['){
				as.push(c);
			}else{
				switch (c) {
				case ')':
					if(as.isEmpty()||'('!=as.pop())
						return false;
					break;//û�н�ifһ��Ҫ������䣬��Ȼ��˳������ִ�У�
				case ']':
					if(as.isEmpty()||'['!=as.pop())
						return false;
					break;
				case '}':
					if(as.isEmpty()||'{'!=as.pop())
						return false;
					break;
				}
			}
		}
		return as.isEmpty();
	}
}