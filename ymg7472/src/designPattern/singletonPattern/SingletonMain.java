package designPattern.singletonPattern;



/** code template
 * <pre>
 * singletonPattern 
 * Main.java
 *
 * ���� : �̱��� ���� ���� 
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public class SingletonMain {
	public static void main(String[] args) {
		System.out.println("Start");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1 == obj2){
			System.out.println("obj1 �� obj2 �� ���� �ν��Ͻ��Դϴ�.");
		}else{
			System.out.println("obj1 �� obj2 �� �ٸ� �ν��Ͻ��Դϴ�.");
		}
		System.out.println("End");
	}
}