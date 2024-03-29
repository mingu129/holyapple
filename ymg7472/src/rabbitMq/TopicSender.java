package rabbitMq; 

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * <pre>
 * rabbitMq 
 * TopicSender.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 21.
 * @author : ymg74
 * @version : v1.0
 */
public class TopicSender {

	private static final String EXCHANGE_NAME = "ymg7472";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("dev-swh.ga");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		String routingKey = "test";
		String message = "이게 설마 들어올까";

		channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
	}
	//..
}