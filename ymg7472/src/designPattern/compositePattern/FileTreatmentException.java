package designPattern.compositePattern;
/**
 * <pre>
 * kr.co.swh.lecture.engineering.scene3.composite
 * FileTreatmentException.java
 *
 * ���� :���Ͽ� Entry�� �߰��Ϸ��� �� �� �߻��ϴ� ���� Ŭ����
 * </pre>
 * 
 * @since : 2017. 10. 3.
 * @author : tobby48
 * @version : v1.0
 */
public class FileTreatmentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileTreatmentException(){

	}
	public FileTreatmentException(String msg){
		super(msg);
	}
}