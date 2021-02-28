package designPattern.compositePattern;
import java.util.Iterator;
import java.util.Vector;

/**
 * <pre>
 * kr.co.swh.lecture.engineering.scene3.composite
 * Directory.java
 *
 * ���� :�׸��� �ش��ϴ� Ŭ����
 * </pre>
 * 
 * @since : 2017. 10. 3.
 * @author : tobby48
 * @version : v1.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Directory extends Entry {
	private String name;

	private Vector directory = new Vector();

	public Directory(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public int getSize(){
		int size = 0;
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			size += entry.getSize();
		}
		return size;
	}
	public Entry add(Entry entry){
		directory.add(entry);
		return this;
	}
	protected void printList(String prefix){
		System.out.println(prefix + "/" + this);
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			entry.printList(prefix + "/" + name);
		}
	}
}