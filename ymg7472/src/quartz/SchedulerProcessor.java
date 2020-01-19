package quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * <pre>
 * kr.co.swh.lecture.opensource.quartz 
 * SchedulerProcessor.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2018. 11. 30.
 * @author : tobby48
 * @version : v1.0
 */
public class SchedulerProcessor implements org.quartz.Job{
	private static int count = 0;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(++count + "����");
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count + "������");
	}
}