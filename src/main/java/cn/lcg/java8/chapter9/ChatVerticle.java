package cn.lcg.java8.chapter9;


import cn.lcg.java8.chapter9.util.Runner;
import io.vertx.core.AbstractVerticle;

public class ChatVerticle extends AbstractVerticle{
    
    public static void main(String args[]) {
        Runner.runExample(ChatVerticle.class);
    }
    
    public void start() throws Exception {
        
        vertx.createNetServer().connectHandler(socket -> {
//            container.getLogger().info("socket connected");
//            socket.dataHandler(new User(socket, this));
            socket.handler(new User(socket, this));
        }).listen(10_000);
//        container.getLogger().info("ChatVerticle started");
        
    }

}
