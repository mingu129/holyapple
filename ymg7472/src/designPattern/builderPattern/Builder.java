package designPattern.builderPattern;

/**
 * <pre>
 * builderPattern 
 * Builder.java
 *
 * ���� :������ �����ϱ� ���� �޼ҵ带 ������ �߻�Ŭ����
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public abstract class Builder {
	public abstract void makeTitle(String title);
	public abstract void makeString(String str);
	public abstract void makeItems(String[] items);
	public abstract Object getResult();
}