package thread;

public class ThreadBasic extends Thread {
	private int index;
	
	public ThreadBasic(int index) {
		this.index = index;
	}
	
	public void run() {
		System.out.println(index + "��° �����尡 �����մϴ�.");
	}

	public static void main(String[] args) {
		for(int i=0; i<15; i++) {
			Thread t = new ThreadBasic(i);
			t.start();
		}
	}
}