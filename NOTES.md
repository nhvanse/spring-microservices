# Notes

## 1. Spring web

- **DispatcherServlet** - Front Controller Pattern
    - it would map the request to the right controller
    - Auto Configuration (DispatcherServletAutoConfiguration)

- How does an object get converted to JSON?
    - @ResponseBody + JacksonHttpMessageConverters
        - Auto Configuration (JacksonHttpMessageConvertersConfiguration)

- Who is configuring error mapping?
    - Auto Configuration(ErrorMvcAutoConfiguration)

- How are all jars available (Spring, Spring MVC, Jackson, Tomcat)
    - Starter Projects - Spring Boot Starter Web (spring-webmvc, spring-web, spring-boot-starter-tomcat,
      spring-boot-starter-json)

- Build URI from current request, or servletMapping, or context
    - User ServletUriComponentsBuilder
        - Example: ```URI location = ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(savedUser.getId())
          .toUri();```

- Handle exception
    - `@ControllerAdvice` for class
    - `@ExceptionHandler` for method
    - read `ResponseEntityExceptionHandler`

- Documentation
    - springdoc

- Content Negotiation
    - Same Resource - Same URI. However, Different Representations
    - Example: XML or JSON, English or Vietnamese
    - Example: XML use dependency `jackson-dataformat-xml`

- Internationalization - i18n
    - Accept-Language in Header
    - use `org.springframework.context.MessageSource`
    - to get Locale: use `LocaleContextHolder`

- Versioning REST API
    - Options:
        - URL Versioning - Twitter: /v1/person, /v2/person
        - Request Params Versioning - Amazon: /person?version=1, /person?version=2
        - Header Versioning - Microsoft: X-API-VERSION=1
        - MediaType Versioning - Github - aka Content Negotiation - Accept Header
            - same URL, produces=application/vnd/company.app-v1+json
            - same URL, produces=application/vnd/company.app-v2+json
    - Factors to consider
        - URI Pollution, Misuse of HTTP Headers, Caching, Can use on the browser?, API Documentation -> No Perfect
          Solution

- HATEOAS
    - abbreviation of 'Hypermedia as the Engine of Application State'
    - How to enhance API to perform subsequent actions?
        - Option 1: Custom format and implementation
        - Option 2: Use Standard Implementation
            - **HAL** (JSON Hypertext Application Language)
            - HATEOAS generate HAL for API
    - `spring-boot-starter-hateoas`
  <details>
  <summary>Example</summary>

  ```
    EntityModel<User> entityModel = EntityModel.of(user);
    WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllUsers());
    entityModel.add(link.withRel("all-users"));
  ```
  </details>

- Customize API Response
  -
        1. Customize field name - @JSONProperty
    -
        2. Return only selected fields

        - Static Filtering: @JsonIgnoreProperties @JsonIgnore
        - Dynamic Filtering: @JsonFilter with FilterProvider
            - if we use @JsonFilter, we need to configure FilterProvider.
            - If not, an InvalidDefinitionException occurs

- Spring Boot Actuator
    - monitor and manage application in production
    - endpoints:
        - **bean**: list beans in app
        - **health**: health info
        - **metrics**
        - **mappings**
        - ...
- Explore Rest API using HAL explorer
    - HAL (hypertext application language)
    - HAL explorer -> API explorer using HAL
    - pom `spring-data-rest-hal-explorer`

- JPA
    - init sql: `spring.jpa.defer-datasource-initialization=true`

- MySQL
    - use docker run mysql on
      local [run_mysql_on_docker.sh](./1-restful-web-services/src/main/resources/scripts/run_mysql_on_docker.sh)

- Spring security
    - FilterChain
        - All requests should be authenticated
        - If a request is not authenticated, a web page is shown
        - CSRF - POST, PUT
    - Bean: SecurityFilterChain
    - ![Spring Security Filter chain](./images/spring_security_filters_chain.png)
    - ![Spring Security](images/spring_security_1.png)

## 2. Microservices

### 2.1 Introduction

- Microservice: ![img.png](images/microservice_definition.png)
- Microservice:
    - REST
    - Small well-chosen Deployable units
    - Cloud Enabled
- Challenges
    - bounded context: how to divide to some microservices
    - configuration management
    - dynamic scale up and scale down
    - visibility: how to find bug, need to monitor
    - pack of cards: fault tolerance, 1 service go down -> affect others

### 2.2 Spring Cloud

- contains a wide variety of projects: sc config, sc netflix, sc bus, sc foundry, sc cluster
- [https://github.com/in28minutes/spring-microservices-v2](https://github.com/in28minutes/spring-microservices-v2)
- [slide](./docs/Microservices-V2-presentation.pdf)
- Ports:
  ![Ports](./images/spring-cloud-ports.png)

#### 2.2.1 Limit service

- Dependencies: Spring web, dev-tools, actuator, config client
- Port: 8080, 8081,...

#### 2.2.2 Spring cloud config server

- Dependencies: dev-tools, config server
- Port: 8888

## Chrome extension

- Talend API tester