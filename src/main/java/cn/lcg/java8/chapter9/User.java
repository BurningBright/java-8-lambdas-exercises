package cn.lcg.java8.chapter9;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import io.vertx.core.Handler;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetSocket;

public class User implements Handler<Buffer>{
    
    private final Pattern newline = Pattern.compile("\\n");
    
    private final NetSocket socket;
    private final Set names;
    private final EventBus eventBus;
    
    private Optional<String> name;
    
    public User(NetSocket socket, Verticle verticle) {
        Vertx vertx = verticle.getVertx();
        this.socket = socket;
//        names = vertx.sharedData().getSet("names");
        names = vertx.sharedData().getLocalMap("names").keySet();
        eventBus = vertx.eventBus();
        name = Optional.empty();
        System.out.println("created");
    }
    
    @Override
    public void handle(Buffer buffer) {
        System.out.println("handled " + buffer.toString());
        
        newline.splitAsStream(buffer.toString()).forEach(line -> {
            if(!name.isPresent()) {
                System.out.println("no");
//                setName(line);
            } else {
                System.out.println("yes");
//                handleMessage(line);
            }
        });
        
    }

}
