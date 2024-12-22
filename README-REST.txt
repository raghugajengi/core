Spring – RestTemplate 
When a client request is made, it just transfers a representation of the state of the resource to the requester or at the endpoint via HTTP. This information delivered to the client can be in several formats as follows:

JSON (JavaScript Object Notation )

‘RestTemplate’ is a synchronous REST client provided by the core Spring Framework.

Path:

org.springframework.web.client.RestTemplate
Constructors:

- RestTemplate()
- RestTemplate(ClientHttpRequestFactory requestFactory)
- RestTemplate(List<HttpMessageConverter<?>> messageConverters)
It provides a total of 41 methods for interacting with REST resources. But there are only a dozen of unique methods each overloaded to form a complete set of 41 methods.

Operation

Method                        

Action Performed                                                                                                                                                                 

DELETE

delete()	Performs an HTTP DELETE request on a resource at a specified URL.
GET

getForEntity()

getForObject() 

Sends an HTTP GET request, returning a ResponseEntity containing an object mapped from the response body.

Sends an HTTP GET request, returning an object mapped from a response body.

POST

postForEntity() 

postForLocation()

postForObject() 

POSTs data to a URL, returning a ResponseEntity containing an object mapped from the response body.

POSTs data to a URL, returning the URL of the newly created resource.

POSTs data to a URL, returning an object mapped from the response body.

PUT

put() 	PUTs resource data to the specified URL.
PATCH

patchForObject()	Sends an HTTP PATCH request, returning the resulting object mapped from the response body.
HEAD

headForHeaders()	Sends an HTTP HEAD request, returning the HTTP headers for the specified resource URL.
ANY

exchange() 

execute()

Executes a specified HTTP method against a URL, returning a ResponseEntity containing an object.

Executes a specified HTTP method against a URL, returning an object mapped from the response body.

OPTIONS

optionsForAllow()	– Sends an HTTP OPTIONS request, returning the Allow header for the specified URL.s


In order to use RestTemplate, we can create an instance via as shown below: 

RestTemplate rest = new RestTemplate();
Also, you can declare it as a bean and inject it as shown below as follows:

// Annotation  
@Bean

// Method 
public RestTemplate restTemplate() 
{
 return new RestTemplate();
}

A. File: UserData.java (Domain class)

Lombok:
This class uses the Lombok library to automatically generate Getter/Setter methods with @Data annotation.
Lombok’s dependency is as depicted below as follows:
Maven – pom.xml

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

B. RestApiController.java (Rest Controller – REST API)

GET – Returns domain data in JSON form.
POST- Returns domain data wrapped in ResponseEntity along with headers.

C. File: RestTemplateProvider.java (RestTemplate implementation)

GET – Consumes REST API’s GET mapping response and returns domain object.
POST – Consumes REST API’s POST mapping response and return ResponseEntity object.

D. File: ConsumeApiController.java (Regular Controller – Consume REST API)

Uses RestTemplate to get the data from REST API and accordingly changes and returns a view.