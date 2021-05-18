package designPattern.factoryMethodPattern;

/**
 * <pre>
 * kr.co.swh.lecture.engineering.scene3.factory 
 * IDCard.java
 *
 * ���� :�޼ҵ� use()�� �����ϰ� �ִ� Ŭ����
 * </pre>
 * 
 * @since : 2017. 10. 3.
 * @author : tobby48
 * @version : v1.0
 */
public class IDCard extends Product {
	private String owner;

	public IDCard(String owner){
		System.out.println(owner + "�� ī�带 ����ϴ�.");
		this.owner = owner;
	}
	public void use(){
		System.out.println(owner + "�� ī�带 ����մϴ�.");
	}
	public String getOwner(){
		return owner;
	}
}