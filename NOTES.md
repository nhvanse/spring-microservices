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
  - Starter Projects - Spring Boot Starter Web (spring-webmvc, spring-web, spring-boot-starter-tomcat, spring-boot-starter-json)

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
    - URI Pollution, Misuse of HTTP Headers, Caching, Can use on the browser?, API Documentation -> No Perfect Solution

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
  - 1. Customize field name - @JSONProperty
  - 2. Return only selected fields
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
## Chrome extension
- Talend API tester