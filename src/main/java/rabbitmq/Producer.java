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

        //4.通过channel发送数据
        String msg = "Hello RabbitMQ!";

        for (int i = 0; i < 5; i++) {
            channel.basicPublish("","test_01",null,msg.getBytes());
        }

        //5.关闭相关连接
        channel.close();
        connection.close();
    }
}
