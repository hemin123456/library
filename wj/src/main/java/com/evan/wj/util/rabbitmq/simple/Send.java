package com.evan.wj.util.rabbitmq.simple;

import com.evan.wj.util.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Send {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws IOException {
        //获取mq连接
        Connection connection = ConnectionUtil.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //消息内容
        String message = "Hello World!";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }

}
