package cn.lcg.java8.chapter9;

/*
public class SimpleVerticle extends AbstractVerticle{

    public static final String ALL_PRODUCTS_ADDRESS = "example.all.products";

    private final ObjectMapper mapper = new ObjectMapper();
    private final ProductService service;

    public SimpleVerticle(final ApplicationContext context) {
  
        service = (ProductService) context.getBean("productService");  
  
    }

    private Handler<Message<String>> allProductsHandler(ProductService service, String name) {
        return ms2g -> vertx.<String> executeBlocking(future -> {
            try {
                future.complete(mapper.writeValueAsString(service.getAllProducts(ms2g.body())));
            } catch (JsonProcessingException e) {
                System.out.println("Failed to serialize result");
                future.fail(e);
            }
        }, result -> {
            if (result.succeeded()) {
                ms2g.reply(result.result());
            } else {
                ms2g.reply(result.cause().toString());
            }
        });
    }

    @Override
    public void start() throws Exception {
        super.start();

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< CONSUMER >>>>>>>>>>>>>>>>>>>>>>>>>");
        vertx.eventBus().<String> consumer(ALL_PRODUCTS_ADDRESS).handler(allProductsHandler(service, "message"));

    }
}
*/