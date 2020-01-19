package thread;

import java.util.LinkedList;
public class ThreadBasic4 extends Thread {
	private int index;

	public ThreadBasic4(int index) {
		this.index = index;
	}
	public void run() {
		System.out.println(index + "��° �����尡 �����մϴ�.");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {

		}
		System.out.println(index + "��° �����尡 �����մϴ�.");
	}

	public static void main(String[] args) {
		LinkedList<Thread> threadList = new LinkedList<Thread>();
		for(int i=0; i<15; i++) {
			Thread t = new ThreadBasic4(i);
			t.start();
			threadList.add(t);
		}
		for(int i=0; i<threadList.size(); i++) {
			Thread t = threadList.get(i);
			try {
				t.join();		//	�ش� �����尡 ����� �� ���� ��ٸ���. �����Լ��� ���� �������� ȣ��� �� �ְ� ����
			}catch(Exception e) {
			}
		}
		System.out.println("�����Լ��� �����մϴ�.");
	}
}