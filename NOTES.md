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
## Chrome extension
- Talend API tester