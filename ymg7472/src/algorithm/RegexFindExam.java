package algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindExam {

	public static void main(String[] args) {

		String content = "https://news.naver.com/main/read.nhn?mode=LS2D&mid=shm&sid1=100&sid2=269&oid=003&aid=0009650125";

		System.out.println(content);

		System.out.println("\n========== ����ǥ������ ���ڿ� �˻� ==================");

		// [name] = value �� ���� �������� �Ǿ� �ִ� ���ڿ��� �˻��ϴ� ����ǥ��
		Pattern pattern = Pattern.compile("(?<=(&oid=|\\?oid=)|(&aid=|\\?aid=))[\\d]+"); 
		Matcher matcher = pattern.matcher(content);

		// ���� ǥ���� �˻��� ���ڿ� ���ϱ�
		// find() �޼ҵ尡 false ��ȯ�� ������ �ݺ� 
		while(matcher.find()) {
			//group() �޼ҵ带 ȣ���ϰ� ���� ǥ���� ��ġ�� ���ڿ��� ����
			System.out.println(matcher.group());
			
		}
	}
}
