package cn.lcg.java8.chapter9;

import org.vertx.java.deploy.Verticle;

public class ChatVerticle extends Verticle{

    @Override
    public void start() throws Exception {
        vertx.createNetServer().connectHandler(socket -> {
            container.getLogger().info("socket connected");
            socket.dataHandler(new User(socket, this));
        }).listen(10_000);
        container.getLogger().info("ChatVerticle started");
    }

}
