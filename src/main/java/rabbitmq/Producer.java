package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
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


        //4.声明
//        String exchangerName = "test_direct_exchange";
//        String routingKey = "test.direct";

        String exchangerName = "test_fanout_exchange";
        String routingKey = "user.topicsss";
        String routingKey1 = "user.sstopic.testsss";
        String routingKey2 = "user.sss";

        //4.通过channel发送数据
        String msg = "Hello RabbitMQ! user.topic";
        String msg1 = "Hello RabbitMQ! user.topic.test";
        String msg2 = "Hello RabbitMQ! user.topic.666";
//        for (int i = 0; i < 5; i++) {
        channel.basicPublish(exchangerName,routingKey,null,msg.getBytes());
        channel.basicPublish(exchangerName,routingKey1,null,msg1.getBytes());
        channel.basicPublish(exchangerName,routingKey2,null,msg2.getBytes());
//        }

        //5.关闭相关连接
        channel.close();
        connection.close();
    }
}
