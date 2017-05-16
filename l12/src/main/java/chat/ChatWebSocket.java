package chat;

import mongo.service.MongoDBService;
import org.bson.Document;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.Set;

@WebSocket
public class ChatWebSocket {
    private Set<ChatWebSocket> users;
    private Session session;
    private MongoDBService db = new MongoDBService();

    public ChatWebSocket(Set<ChatWebSocket> users) {
        this.users = users;
        db.initialize("localhost", 27017, "testJavaMongo");
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
        for (ChatWebSocket user : users) {
            try {
                db.insert("messages", new Document("message", data));
                user.getSession().getRemote().sendString(data);
                System.out.println("Sending message: " + data);
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }
    }

    @OnWebSocketConnect
    public void onOpen(Session session) throws IOException {
        users.add(this);
        setSession(session);
        for (Document doc : db.findCustom("messages", new Document())){
            this.getSession().getRemote().sendString(doc.getString("message"));
        }
        System.out.println("onOpen");
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        users.remove(this);
        System.out.println("onClose");
    }
}
