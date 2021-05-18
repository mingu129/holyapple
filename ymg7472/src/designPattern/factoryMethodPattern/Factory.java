package designPattern.factoryMethodPattern;

/**
 * <pre>
 * kr.co.swh.lecture.engineering.scene3.factory
 * Factory.java
 *
 * ���� :�޼ҵ� create()�� �����ϰ� �ִ� �߻�Ŭ����
 * </pre>
 * 
 * @since : 2017. 10. 3.
 * @author : tobby48
 * @version : v1.0
 */
public abstract class Factory {
	public final Product create(String owner){
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	protected abstract Product createProduct(String owner);
	protected abstract void registerProduct(Product product);
}