package cn.lcg.java8.chapter9;
/*
@Service  
public class ProductService {  
  
    @Autowired  
    private ProductRepository repo;  
  
    public List<Product> getAllProducts(String productId) {  
        System.out.println("productid : " + productId);  
        return repo.findAll();  
    }  
  
    public void getProduct(String productId) {  
        System.out.println("productid : " + productId);  
    }  
  
  public static void main( String[] args ) {  
  ApplicationContext context = new AnnotationConfigApplicationContext(SimpleSpringConfiguration.class);  
  final Vertx vertx = Vertx.vertx();  
  vertx.deployVerticle(new SpringSimpleVerticle(context));  
  vertx.deployVerticle(new ServerVerticle());  
}  
} 
*/