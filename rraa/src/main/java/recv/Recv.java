/**
 * @author:mj
 * @date:2017年5月10日
 */
package recv;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Basic.Consume;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * @Title:
 * @Description:
 * @author: MJ
 * @Date:2017年5月10日
 * @Version:1.0
 */
public class Recv {
	
	public static final String QUEUE_NAME="hello";
	public static Connection con=null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Channel channel=getChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			System.out.println("waiting for message...");
			Consumer consume= new DefaultConsumer(channel){
				/**
				 * Title:
				 * Description:
				 **/
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String message=new String(body, "UTF-8");
					System.out.println("receive message:"+message);
				}
			};
			channel.basicConsume(QUEUE_NAME, true,consume);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Channel getChannel() throws IOException, TimeoutException{
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("127.0.0.1");
		con=factory.newConnection();
		Channel channel=con.createChannel();
		return channel;
	}
}
