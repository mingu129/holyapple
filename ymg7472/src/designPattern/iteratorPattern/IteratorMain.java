package designPattern.iteratorPattern;

/**
 * <pre>
 * iteratorPattern 
 * IteratorMain.java
 *
 * ���� : å���̿� å�� ���� ��, ������� �ϳ��� ���� å �̸��� ����ϴ� ���α׷�
 * </pre>
 * 
 * @since : 2021. 2. 21.
 * @author : ymg74
 * @version : v1.0
 */
public class IteratorMain {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.addBook(new Book("�ڹٽ�ũ��Ʈ"));
		bookShelf.addBook(new Book("���̽�"));
		bookShelf.addBook(new Book("����������"));
		bookShelf.addBook(new Book("�ڹ�"));
		Iterator it = bookShelf.iterator();
		while (it.hasNext()) {
			Book book = (Book)it.next();
			System.out.println(book.getName());
		}
	}
}