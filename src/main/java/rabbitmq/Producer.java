package rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/14 17:15
 * @Description:
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.244.142.113");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");

        //2. 通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3.通过connection创建一个channel
        Channel channel = connection.createChannel();

        Map<String, Object> headers = new HashMap<String, Object>();

        headers.put("my1", "111");
        headers.put("my2", "222");

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .deliveryMode(2)
                .contentEncoding("UTF-8")
                .contentType("text/plain")
                .expiration("10000")
                .headers(headers)
                .build();
        //4.声明
//        String exchangerName = "test_direct_exchange";
//        String routingKey = "test.direct";

        String exchangerName = "test_fanout_exchange";
        String routingKey = "user.topicsss";
        String routingKey1 = "user.sstopic.testsss";
        String routingKey2 = "user.sss";

        channel.confirmSelect();
        //4.通过channel发送数据
        String msg = "Hello RabbitMQ! user.topic";
        String msg1 = "Hello RabbitMQ! user.topic.test";
        String msg2 = "Hello RabbitMQ! user.topic.666";
//        for (int i = 0; i < 5; i++) {
        channel.basicPublish(exchangerName,routingKey,properties,msg.getBytes());
        try {
            if (!channel.waitForConfirms()) {
                System.out.println("send message failed");
                //do something else...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.basicPublish(exchangerName,routingKey1,properties,msg1.getBytes());
        try {
            if (!channel.waitForConfirms()) {
                System.out.println("send message failed");
                //do something else...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.basicPublish(exchangerName,routingKey2,properties,msg2.getBytes());
        try {
            if (!channel.waitForConfirms()) {
                System.out.println("send message failed");
                //do something else...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }

        //5.关闭相关连接
        channel.close();
        connection.close();
    }
}
