Spring Boot – Architecture

The main aim of spring boot is to remove the XML and annotations-based configuration settings from the application. 
Along with this spring boot provides the following benefits such as opinionated(options to later change the configuration), 
convention over configuration, stand-alone, and production-ready.

Explanation:

1. The Client makes an HTTP request(GET, PUT, POST, etc.)
2. The HTTP request is forwarded to the Controller. The controller maps the request. It processes the handles and calls the server logic.
3. The business logic is performed in the Service layer. The spring boot performs all the logic over the data of the database which is mapped to the spring boot model class 
through Java Persistence Library(JPA).

4. The JSP page is returned as Response from the controller.

Spring Boot Annotation:

Spring Boot Annotations are a form of metadata that provides data about a spring application.
Spring annotations are present in the org.springframework.boot.autoconfigure and org.springframework.boot.autoconfigure.condition 
packages are commonly known as Spring Boot annotations.

Spring Boot Annotations List

@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
Auto-Configuration Conditions
@ConditionalOnClass, and @ConditionalOnMissingClass
@ConditionalOnBean, and @ConditionalOnMissingBean
@ConditionalOnProperty
@ConditionalOnResource
@ConditionalOnWebApplication and @ConditionalOnNotWebApplication
@ConditionalExpression
@Conditional

1. @SpringBootApplication Annotation
This annotation is used to mark the main class of a Spring Boot application. It encapsulates @SpringBootConfiguration , 
@EnableAutoConfiguration , and @ComponentScan annotations with their default attributes.

@SpringBootApplication

// Class
public class DemoApplication {

    // Main driver method
    public static void main(String[] args)
    {

        SpringApplication.run(DemoApplication.class, args);
    }
}

2. @SpringBootConfiguration Annotation
It is a class-level annotation that is part of the Spring Boot framework. It implies that a class provides Spring Boot application 
configuration. It can be used as an alternative to Spring’s standard @Configuration annotation so that configuration can be found 
automatically. Most Spring Boot Applications use @SpringBootConfiguration via @SpringBootApplication. If an application uses 
@SpringBootApplication, it is already using @SpringBootConfiguration.

@SpringBootConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }
}

3. @EnableAutoConfiguration Annotation
This annotation auto-configures the beans that are present in the classpath. It simplifies the developer’s work by assuming the 
required beans from the classpath and configure it to run the application. This annotation is part of the spring boot framework. 
For example, when we illustrate the spring-boot-starter-web dependency in the classpath, Spring boot auto-configures Tomcat , 
and Spring MVC . The package of the class declaring the @EnableAutoConfiguration annotation is considered as the default. 
Therefore, we need to apply the @EnableAutoConfiguration annotation in the root package so that every sub-packages and class can
 be examined.

@Configuration
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

4. @ComponentScan Annotation
@ComponentScan tells Spring in which packages you have annotated classes that should be managed by Spring. So, for example, 
if you have a class annotated with @Controller which is in a package that is not scanned by Spring, you will not be able to use it as
 a Spring controller. So we can say @ComponentScan enables Spring to scan for things like 
 configurations, controllers, services, and other components that are defined. 
 Generally, @ComponentScan annotation is used with @Configuration annotation to specify the package for Spring to scan for components.
@Configuration
@ComponentScan

// Main class
public class Application {

    // Main driver method
    public static void main(String[] args)
    {

        SpringApplication.run(Application.class, args);
    }
}

5. @ConditionalOnClass Annotation and @ConditionalOnMissingClass Annotation
@ConditionalOnClass Annotation used to mark auto-configuration bean if the class in the annotation’s argument is present/absent.

@Configuration
@ConditionalOnClass(MongoDBService.class)

class MongoDBConfiguration {
    // Insert code here
}

6. @ConditionalOnBean Annotation and @ConditionalOnMissingBean Annotation
These annotations are used to let a bean be included based on the presence or absence of specific beans.
@Bean
@ConditionalOnMissingBean(type = "JpaTransactionManager")

JpaTransactionManager jpaTransactionManager(
    EntityManagerFactory entityManagerFactory)
{
    // Insert code here
}

7. @ConditionalOnProperty Annotation / 8. @ConditionalOnResource Annotation
These annotations are used to let configuration be included based on the presence and value of a Spring Environment property.

@Bean
@ConditionalOnProperty(name = "usemongodb",
                       havingValue = "local")

DataSource
dataSource()
{
    // Insert code here
}

@Bean
@ConditionalOnProperty(name = "usemongodb",
                       havingValue = "prod")

DataSource
dataSource()
{
    // Insert code here
}

Request Handling and Controller annotations:
Some important annotations comes under this category are:

@Controller
@RestController
@RequestMapping
@RequestParam
@PathVariable
@RequestBody
@ResponseBody
@ModelAttribute

1. @Controller Annotation
This annotation provides Spring MVC features. It is used to create Controller classes and simultaneously it handles the HTTP requests.
 Generally we use @Controller annotation with @RequestMapping annotation to map HTTP requests with methods inside a controller class.

 //Create a Java class and use @Controller annotation to make it controller class
@Controller
public class MyController{
  public String GFG(){
    //insert code here
  }
}

2. @RestController Annotation
This annotation is used to handle REST APIs such as GET, PUT, POST, DELETE etc. and also used to create RESTful web services using 
Spring MVC.
It encapsulates @Controller annotation and @ResponseBody annotation with their default attributes.

 @RestController = @Controller + @ResponseBody 

3. @RequestMapping Annotation
This annotation is used to map the HTTP requests with the handler methods inside the controller class.
//Java program to demonstrate @RequestMapping annotation
@RestController
public class MyController{
  @RequestMapping(value=" ",method=RequestMapping.GET)
  public String GFG(){
    //insert code here
  }
}

For handling specific HTTP requests we can use

@GetMapping
@PutMapping
@PostMapping
@PatchMapping
@DeleteMapping

4. @RequestParam Annotation
This annotation is basically used to obtain a parameter from URI. In other words, we can say that @RequestParam annotation is used to read 
the form data and binds the web request parameter to a specific controller method.

//Java code to demonstrate @RequestParam annotation
@RestController
public class MyController{
  
  @GetMapping("/authors")
  public String getAuthors(@RequestParam(name="authorName") String name){
    //insert code here
  }
}

5. @PathVariable Annotation
This annotation is used to extract the data from the URI path. It binds the URL template path variable with method variable.

//Java Program to Demonstrate @PathVariable annotation
@RestController
public class MyController{
  
    @GetMapping("/author/{authorName}")
    public String getAuthorName(@PathVariable(name = "authorName") String name){
      //insert your code here
    }
  
}

6. @RequestBody Annotation
This annotation is used to convert HTTP requests from incoming JSON format to domain objects directly from request body. 
Here method parameter binds with the body of the HTTP request.

// Java Code to Demonstrate @RequestBody annotation
@RestController
public class MyController{
  
  @GetMapping("/author")
  public void printAuthor(@RequestBody Author author){
    //insert code here
  }
}

7. @ResponseBody Annotation
This annotation is used to convert the domain object into HTTP request in the form of JSON or any other text. 
Here, the return type of the method binds with the HTTP response body.

//Java code to demonstrate @ResponseBody annotation
@Controller
public class MyController{
  
  public @ResponseBody Author getAuthor(){
    Author author = new Author();
    author.setName("GFG");
    author.setAge(20);
    return author;
  }
}

8. @ModelAttribute Annotation
This annotation refers to model object in Spring MVC. It can be used on methods or method arguments as well.

Example:

@ModelAttribute("author")
public Author author(){
  //insert code here
}
Here, we don’t need to add object explicitly to the model, because automatically object will be the part of the attribute.