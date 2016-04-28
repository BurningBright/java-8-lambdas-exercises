package cn.lcg.java8.chapter9;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.deploy.Verticle;

public class User implements Handler<Buffer>{
    
    private final Pattern newline = Pattern.compile("\\n");
    
    private final NetSocket socket;
    private final Set<String> names;
    private final EventBus eventBus;
    
    private Optional<String> name;
    
    public User(NetSocket socket, Verticle verticle) {
        Vertx vertx = verticle.getVertx();
        this.socket = socket;
        names = vertx.sharedData().getSet("names");
        eventBus = vertx.eventBus();
        name = Optional.empty();
    }
    
    @Override
    public void handle(Buffer buffer) {
        newline.splitAsStream(buffer.toString()).forEach(line -> {
            if(!name.isPresent()) {
//                setName(line);
            } else {
//                handleMessage(line);
            }
        });
    }

}
