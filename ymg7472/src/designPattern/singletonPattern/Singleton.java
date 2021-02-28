package designPattern.singletonPattern;


/**
 * <pre>
 * singletonPattern 
 * Singleton.java
 *
 * ���� : �ν��Ͻ��� �ϳ��� �����ϴ� Ŭ����
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public class Singleton {

	private static Singleton singleton = new Singleton();

	private Singleton(){
		System.out.println("�ν��Ͻ��� �����߽��ϴ�.");
	}
	public static Singleton getInstance(){
		System.out.println("�ν��Ͻ��� ��ȯ�մϴ�.");
		return singleton;
	}
}