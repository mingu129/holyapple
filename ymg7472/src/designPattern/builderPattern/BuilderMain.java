package designPattern.builderPattern;

/**
 * <pre>
 * builderPattern 
 * BuilderMain.java
 *
 * ���� : �Ϲ� �ؽ�Ʈ ���ϰ� HTML������ ����� Ŭ����
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public class BuilderMain {
	public static void main(String[] args){
		Director director;
		director = new Director(new TextBuilder());
		String result = (String)director.construct();
		System.out.println(result);

		director = new Director(new HTMLBuilder());
		String filename = (String)director.construct();
		System.out.println(filename + "�� �ۼ��Ǿ����ϴ�.");
	}
}