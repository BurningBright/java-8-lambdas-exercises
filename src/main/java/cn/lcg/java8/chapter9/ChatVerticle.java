package cn.lcg.java8.chapter9;


import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

import cn.lcg.java8.chapter9.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetServer;

public class ChatVerticle extends AbstractVerticle{
    
    public static void main(String args[]) {
        Runner.runExample(ChatVerticle.class);
    }
    
    public void start() throws Exception {
        
        super.start();
        
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< CONSUMER >>>>>>>>>>>>>>>>>>>>>>>>>");
        
        // Register to listen for messages coming IN to the server
        EventBus eb = vertx.eventBus();
        eb.consumer("chat.to.server").handler(message -> {
          String timestamp = DateFormat
                  .getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM)
                  .format(Date.from(Instant.now()));
          System.out.println("Server recevied: " + message.body());
          
          eb.publish("chat.to.client", timestamp + ": " + message.body());
        });
        
//        NetServerOptions options = new NetServerOptions().setPort(4321);
        NetServer server = vertx.createNetServer();

        server.connectHandler(socket -> {
            socket.handler(buffer -> {
                System.out.println("I received some bytes: " + buffer.length());
                System.out.println("It looks like this: \n" + buffer.toString());
                socket.write(buffer);
                //socket.end();
                
            });
            
            socket.closeHandler(v -> {
                System.out.println("The socket has been closed");
            });
            
            socket.exceptionHandler(e -> {
                System.out.println(e.getMessage());
            });
            
        }).listen(8080);
        
        System.out.println("I'm a server");
        
        vertx.setPeriodic(1000, t -> vertx.eventBus().publish("chat.to.client", "news from the server!"));
    }

}
