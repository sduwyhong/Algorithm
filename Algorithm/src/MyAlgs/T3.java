package MyAlgs;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

//创建一个静态方法，给它传入一个对象，请循环的打印出该对象所在类的类名和所实现的方法名
public class T3 {

	public static void main(String[] args) {
		String obj = new String();
		describeObject(obj);
	}

	private static void describeObject(String obj) {
		
		if(obj == null) throw new IllegalArgumentException();
		
		Class _class = obj.getClass();
		System.out.printf("类名：%s\n", _class.getSimpleName());
		Method[] methods = _class.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.printf("方法%d：%s", i, methods[i].getName());
			Class[] params = methods[i].getParameterTypes();
			for (int j = 0; j < params.length; j++) {
				if(j == 0) System.out.print("(");
				if(j == params.length - 1) System.out.printf("%s)", params[j].getSimpleName());
				else System.out.printf("%s, ", params[j].getSimpleName());
			}
			System.out.println();
		}
	}

}
