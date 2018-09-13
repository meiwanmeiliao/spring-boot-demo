package com.vortex.webSocket;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @AUTH zhuolin
 * @DATE 2018/7/31
 * @description:
 **/
@ServerEndpoint(value = "/websocket/{userName}")
@Component
public class WebSocketDemo {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet = new CopyOnWriteArraySet<WebSocketDemo>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static Map<Long, Map<String, String>> messages = new LinkedHashMap<>(100);

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName) throws UnsupportedEncodingException {
        this.session = session;
        session.getUserProperties().put("userName", URLDecoder.decode(userName,"UTf-8"));
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        try {
            for (Long key : messages.keySet()) {
                for (String userInfo : messages.get(key).keySet()) {
                    sendMessage(userInfo + "(" + simpleDateFormat.format(new Date(key)) + "):" + messages.get(key).get(userInfo));
                }

            }
//            sendMessage("当前在线人数为" + getOnlineCount());
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        long time = System.currentTimeMillis();
        if (messages.size() >= 100) {
            messages.remove(messages.entrySet().iterator().next().getKey());
        }
        if (!messages.containsKey(time)) {
            messages.put(time, new HashMap<>());
        }
        messages.get(time).put(session.getUserProperties().get("userName").toString(), message);
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        for (WebSocketDemo item : webSocketSet) {
            try {
                item.sendMessage(session.getUserProperties().get("userName").toString() + "(" + simpleDateFormat.format(new Date(time)) + "):" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) throws IOException {
        Long time = System.currentTimeMillis();
        if (messages.size() >= 100) {
            messages.remove(messages.entrySet().iterator().next().getKey());
        }
        if (!messages.containsKey(time)) {
            messages.put(time, new HashMap<>());
        }
        messages.get(time).put("系统消息", message);
        for (WebSocketDemo item : webSocketSet) {
            try {
                item.sendMessage("系统消息" + "(" + simpleDateFormat.format(new Date(time)) + "):" + message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketDemo.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketDemo.onlineCount--;
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void test() {
        try {
            sendInfo("群发消息");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
