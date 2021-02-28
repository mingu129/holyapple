package designPattern.compositePattern;
/**
 * <pre>
 * kr.co.swh.lecture.engineering.scene3.composite
 * Entry.java
 *
 * ���� :File�� Directory�� ���Ͻ��ϴ� �߻�Ŭ����
 * </pre>
 * 
 * @since : 2017. 10. 3.
 * @author : tobby48
 * @version : v1.0
 */
public abstract class Entry {

	public abstract String getName();
	public abstract int getSize();

	public Entry add(Entry entry)throws FileTreatmentException{
		throw new FileTreatmentException();
	}

	public void printList(){
		printList("");
	}

	protected abstract void printList(String prefix);

	public String toString(){
		return getName() + "(" + getSize() + ")";
	}
}