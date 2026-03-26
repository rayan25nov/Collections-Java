# 🎯 Top Spring Boot Interview Questions

## **1. Core Framework**

- **What is Spring Boot and how is it different from the Spring Framework?**
  - _Answer:_ Spring Boot is an extension of Spring that eliminates boilerplate configuration. Key differences include **Auto-configuration**, **Starter dependencies**, and **Embedded servers** (like Tomcat).
- **What is "Auto-configuration" in Spring Boot?**
  - _Answer:_ It’s the process where Spring Boot automatically configures your application based on the jar dependencies you’ve added (e.g., if `spring-boot-starter-web` is present, it sets up Tomcat and Spring MVC).
- **What are Spring Boot Starters?**
  - _Answer:_ They are a set of convenient dependency descriptors (POMs) that you can include in your application to get all the relevant libraries for a specific technology (e.g., Data JPA, Security).

## **2. Architecture & Data**

- **Explain the Tiered/Layered Architecture in Spring Boot.**
  - _Answer:_ It consists of the **Controller** (Request handling), **Service** (Business logic), and **Repository** (Database access). This separates concerns and makes the code testable.
- **What is the IoC Container and Dependency Injection?**
  - _Answer:_ Inversion of Control (IoC) means the framework manages object lifecycles. Dependency Injection (DI) is the pattern used to provide those objects (Beans) to classes that need them, usually via `@Autowired`.
- **What does `@Transactional` do?**
  - _Answer:_ It ensures a suite of database operations are "Atomic"—either they all succeed or they all roll back, maintaining data integrity.

## **3. Security & Web**

- **What is the difference between `@Controller` and `@RestController`?**
  - _Answer:_ `@RestController` is a convenience annotation that combines `@Controller` and `@ResponseBody`, meaning it automatically serializes return objects into JSON/XML.
- **How do you handle Spring Security for a Stateless API?**
  - _Answer:_ You disable CSRF and set the session creation policy to `STATELESS` in the `SecurityFilterChain`.

---

## 🛠 Spring Boot Annotations Guide

| Annotation                         | Category     | What it does                                                                                  |
| :--------------------------------- | :----------- | :-------------------------------------------------------------------------------------------- |
| **`@SpringBootApplication`**       | Core         | The entry point. Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. |
| **`@Component`**                   | IoC          | Marks a class as a Spring-managed Bean.                                                       |
| **`@Service`**                     | Architecture | A specialized `@Component` for business logic.                                                |
| **`@Repository`**                  | Architecture | A specialized `@Component` for DAOs/Database logic; catches platform-specific exceptions.     |
| **`@RestController`**              | Web          | Marks a class as a controller where every method returns data (JSON) instead of a view.       |
| **`@Autowired`**                   | DI           | Tells Spring to inject a dependency automatically.                                            |
| **`@RequestMapping`**              | Web          | Maps a specific URL path to a controller class or method.                                     |
| **`@GetMapping` / `@PostMapping`** | Web          | Shortcuts for `@RequestMapping(method = RequestMethod.GET/POST)`.                             |
| **`@RequestBody`**                 | Web          | Maps the incoming JSON request body to a Java object.                                         |
| **`@PathVariable`**                | Web          | Extracts a value from the URL path (e.g., `/user/{id}`).                                      |
| **`@Data`**                        | Lombok       | Generates Getters, Setters, `toString`, `equals`, and `hashCode` automatically.               |
| **`@Transactional`**               | Data         | Wraps a method in a database transaction for atomicity.                                       |

---

### **Summary of the "Request Flow"**

When a request hits your Spring Boot app:

1.  **Controller** receives the request (using `@GetMapping`/`@PostMapping`).
2.  **Controller** calls the **Service** (injected via `@Autowired`).
3.  **Service** performs business logic and calls the **Repository**.
4.  **Repository** interacts with **MongoDB/SQL** (via `MongoRepository` or `JpaRepository`).
5.  **ResponseEntity** wraps the result and sends it back to the client with a status code.
