package rabbitmq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/14 17:16
 * @Description:
 */
@Slf4j
public class Consumer {

    public static final String QUEUE_NAME = "test_01";

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
        final Channel channel = connection.createChannel();

        //4.声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);


        //5.通过channel接受数据
        channel.basicConsume(QUEUE_NAME, false, "myConsumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();
                //6.获取消息
                String msg = new String(body);

                System.out.println("接收到来自RoutingKey:" + routingKey + "的消息，contentType:  " + contentType + " msg: " + msg);

                channel.basicAck(deliveryTag, false);
            }
        });
    }
}
