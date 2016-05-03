package cn.lcg.java8.chapter9;

import io.vertx.core.Vertx;

public class HelloVertX {

    public static void main(String[] args) {
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(8080);
    }

}
