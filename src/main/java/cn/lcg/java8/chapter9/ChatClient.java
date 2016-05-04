package cn.lcg.java8.chapter9;

import cn.lcg.java8.chapter9.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class ChatClient extends AbstractVerticle{
    
    public static void main(String[] args) {
        Runner.runExample(ChatClient.class);
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
    }

    public void start() throws Exception {
        NetClient client = vertx.createNetClient();
        client.connect(8080, "127.0.0.1", new SendMsg(client, vertx));
        
        
        
    }
}

class SendMsg implements Handler<AsyncResult<NetSocket>> {
    
    private int count = 0;
    private NetClient client;
    private EventBus eb;
    
    
    public SendMsg(NetClient client, Vertx vertx) {
        this.client = client;
        
        eb = vertx.eventBus();
        eb.consumer("chat.to.client", message -> {
            System.out.println("client received" + message.body());
        });
    }
    
    public void handle(AsyncResult<NetSocket> async) {
        if(async.succeeded()) {
            System.out.println("connected");
            
            eb.publish("chat.to.server", "Hello Bus "+ Math.random());
            
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
            });
        } else {
            System.out.println(async.cause().getMessage());
        }
    }
    
    
}