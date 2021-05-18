package designPattern.factoryMethodPattern;
import java.util.Vector;

/**
 * <pre>
 * kr.co.swh.lecture.engineering.scene3.factory
 * IDCardFactory.java
 *
 * ���� :�޼ҵ� createProduct(), registerProduct()�� �����ϰ� �ִ� Ŭ����
 * </pre>
 * 
 * @since : 2017. 10. 3.
 * @author : tobby48
 * @version : v1.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class IDCardFactory extends Factory {
	private Vector owners = new Vector();

	protected Product createProduct(String owner){
		return new IDCard(owner);
	}
	protected void registerProduct(Product product){
		owners.add(((IDCard)product).getOwner());
	}
	public Vector getOwners(){
		return owners;
	}
}