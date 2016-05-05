package cn.lcg.java8.chapter9;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class ChatClient extends AbstractVerticle{
    
    public static void main(String[] args) {
        //Runner.runExample(ChatClient.class);
        /*
        Thread in = new Thread(() ->{
            Scanner input = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            String tmp = input.nextLine();
            while(tmp.endsWith(";;")) {
                sb.append(tmp);
                tmp = input.nextLine();
            }
            sb.append(tmp);
            
        });
        */
        
        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ChatClient());
        vertx.deployVerticle(new ChatVerticle());
    }

    public void start() throws Exception {
        NetClient client = vertx.createNetClient();
        client.connect(8080, "127.0.0.1", new SendMsg(client, vertx));
        
        vertx.eventBus().consumer("chat.to.client", message -> {
            System.out.println("client received: " + message.body());
        });
        
    }
}

class SendMsg implements Handler<AsyncResult<NetSocket>> {
    
    @SuppressWarnings("unused")
    private int count = 0;
    @SuppressWarnings("unused")
    private NetClient client;
    private EventBus eb;
    
    
    public SendMsg(NetClient client, Vertx vertx) {
        this.client = client;
        
        eb = vertx.eventBus();
        
    }
    
    public void handle(AsyncResult<NetSocket> async) {
        if(async.succeeded()) {
            
            System.out.println("connected");
            
            NetSocket socket = async.result().write("Hello World "+ Math.random());
            socket.handler(buffer -> {
                if(buffer.length()>0) {
                    System.out.println(buffer);
                }
                /*
                if(count == 2) {
                    socket.end();
                    client.close();
                    return;
                }
                if(count < 3) {
                    count++;
                    this.handle(async);
                }
                */
                
                eb.publish("chat.to.server", "Hello Bus "+ Math.random());
            });
        } else {
            System.out.println(async.cause().getMessage());
        }
    }
    
    
}