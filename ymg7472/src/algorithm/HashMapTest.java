package algorithm;
import java.util.*;
public class HashMapTest {
	public static void main(String args[]) {
		HashMap<Integer, String> s = new HashMap<Integer, String>();
		s.put(1, "ȫ�浿");
		s.put(2, "��ö��");
		s.put(3, "�迵��");
		s.put(3, "sds");
		if(s.containsKey(3)){
			System.out.println(s.get(3));
		}
		int index=0;
		while(!s.isEmpty()){
			String value = s.remove(++index);
			System.out.println(value);
		}
	}	
}