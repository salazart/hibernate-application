package com.sz.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{userName}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatEndpoint {
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName) throws IOException, EncodeException {
        sessions.add(session);
        users.put(session.getId(), userName);
        broadcast("Connected user:" + userName);
        System.out.println("User created:" + userName + ", session id:" + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException, EncodeException {
        broadcast("Message from " + users.get(session.getId()) + ":" + message);
        System.out.println("Session id:" + session.getId() + ", message from " + users.get(session.getId()) + ":" + message);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        broadcast("Disconnected user " + users.get(session.getId()));
        sessions.remove(session);
        String user = users.get(session.getId());
        users.remove(user);
        System.out.println("Disconnected user " + users.get(session.getId()) + " with session:" + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(String message) throws IOException, EncodeException {
        sessions.forEach(session -> {
            synchronized (session) {
                try {
                    session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
