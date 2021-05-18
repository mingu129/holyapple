package designPattern.factoryMethodPattern;

/**
 * <pre>
 * designPattern.factoryMethodPattern 
 * FactoryMain.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2021. 4. 12.
 * @author : ymg74
 * @version : v1.0
 */
public class FactoryMain {
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("�ھ�");
		Product card2 = factory.create("����");
		Product card3 = factory.create("��Ű");
		card1.use();
		card2.use();
		card3.use();
	}
}