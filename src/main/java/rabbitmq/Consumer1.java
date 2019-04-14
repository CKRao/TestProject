package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/14 20:22
 * @Description:
 */
public class Consumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.244.142.113");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");

        connectionFactory.setAutomaticRecoveryEnabled(true);
        connectionFactory.setNetworkRecoveryInterval(3000);

        //2. 通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3.通过connection创建一个channel
        final Channel channel = connection.createChannel();

        //4.声明
        String exchangerName = "test_direct_exchange";
        String routingKey = "test.direct";
        String queuqName = "test_direct_queue";
        String exchangetype = "direct";

        channel.exchangeDeclare(exchangerName, exchangetype, true, false, false, null);
        channel.queueDeclare(queuqName, false, false, false, null);
        channel.queueBind(queuqName, exchangerName, routingKey);

        //5.接收消息
        channel.basicConsume(queuqName, false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                String contentType = properties.getContentType();
                long deliveryTag = envelope.getDeliveryTag();
                //6.获取消息
                String message = new String(body);

                System.out.println("接收到来自RoutingKey:" + routingKey + "的消息，contentType:  " + contentType + " message: " + message);
                channel.basicAck(deliveryTag, false);
            }
        });

    }
}
