package MyAlgs;
//编程说明StringBuilder和StringBuffer字符串的区别
//StringBuffer线程安全。
//StringBuilder线程不安全。
public class T8 {

	public static void main(String[] args) {
		StringBuffer buffer  = new StringBuffer();
		buffer.append("abe");
		buffer.insert(2, "cd");
		System.out.println(buffer);
		System.out.println(buffer.toString());
	}

}
