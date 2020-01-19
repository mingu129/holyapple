package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class ThreadBasic5 implements Callable<String> {
	private int index;
	
	public ThreadBasic5(int index) {
		this.index = index;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		}catch(Exception e) {

		}
		return index + "��° �����尡 �Ϸ�Ǿ����ϴ�.";
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0; i<15; i++) {
			Callable<String> t = new ThreadBasic5(i);
			Future<String> f = executorService.submit(t);
			try {
				System.out.println(f.get());	//	������ �ϳ��� �Ϸ�Ǵ� ���� ��ٸ���.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}