package designPattern.builderPattern;

/**
 * <pre>
 * builderPattern 
 * Director.java
 *
 * ���� :�ϳ��� ������ ����� Ŭ����
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public class Director {
	private Builder builder;
	
	public Director(Builder builder){
		this.builder = builder;
	}
	public Object construct(){
		this.builder.makeTitle("Greeting");
		this.builder.makeString("��ħ�� ����");
		this.builder.makeItems(new String[]{"���� ��ħ�Դϴ�.", "�ȳ��ϼ���"});
		this.builder.makeString("�㿡");
		this.builder.makeItems(new String[]{"�ȳ��ϼ���", "�ȳ��� �ֹ�����", "�ȳ��� �輼��"});
		return this.builder.getResult();
	}
}