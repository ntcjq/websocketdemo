package com.websocket;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.websocket.WebSocketTest;


/**
 * 向客户端发送消息
 * @author v.cuijq
 *
 */
public class Monitor implements Runnable {

	public static int i;
	
    @Override
    public void run() {
        WebSocketTest webSocketTest = new WebSocketTest();
        synchronized (Monitor.class) {
			i++;
		}
        System.out.println("当前时间"+(i)+":" + new Date());
        webSocketTest.sendToAll("当前时间"+(i)+":" + new Date());
    }

    public void sendMsg() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        newScheduledThreadPool.scheduleWithFixedDelay(new Monitor(), 20, 5, TimeUnit.SECONDS);

    }
}

