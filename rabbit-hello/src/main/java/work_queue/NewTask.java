package work_queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class NewTask {

    private static final  String QUEUE_NAME="work_queue";
    private static Connection con=null;

    public static void main(String[] args) {



        try {
            Channel channel=getChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            StringBuilder message=new StringBuilder("hello,world");

            for (int i=0;i<10;i++){
                message.append(".");
                System.out.println("发送第"+(i+1)+"条消息："+message.toString());
                channel.basicPublish("", QUEUE_NAME, null, message.toString().getBytes("UTF-8"));
            }


            channel.close();
            con.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");
        con=factory.newConnection();
        Channel channel=con.createChannel();
        return channel;
    }
}
