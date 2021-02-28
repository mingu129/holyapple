package designPattern.iteratorPattern;

/**
 * <pre>
 * iteratorPattern 
 * Iterator.java
 *
 * ���� : ����ü�� ��Ҹ� �ϳ��� �������� ���� �������̽�
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public interface Iterator {
	public abstract boolean hasNext();
	public abstract Object next();
}