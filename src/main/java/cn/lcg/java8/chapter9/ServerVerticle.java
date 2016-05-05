package cn.lcg.java8.chapter9;
/*
public class ServerVerticle extends AbstractVerticle {  
    
    @Override  
    public void start() throws Exception {  
      super.start();  
      HttpServer server = vertx.createHttpServer();  
      server.requestHandler(req -> {  
        if (req.method() == HttpMethod.GET) {  
          req.response().setChunked(true);  
    
          if (req.path().equals("/products")) {  
            vertx.eventBus().<String>send(SpringSimpleVerticle.ALL_PRODUCTS_ADDRESS, "123456", result -> {  
              if (result.succeeded()) {  
                req.response().setStatusCode(200).write(result.result().body()).end();  
              } else {  
                req.response().setStatusCode(500).write(result.cause().toString()).end();  
              }  
            });  
          } else {  
            req.response().setStatusCode(200).write("Hello from vert.x").end();  
          }  
    
        } else {  
          // We only support GET for now  
          req.response().setStatusCode(405).end();  
        }  
      });  
    
      server.listen(8080);  
    }  
  }  
*/