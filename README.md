# ⚙️ Execution Framework

A **lightweight, type-safe execution framework** for running units of work with
**clear success/failure semantics**, **strong compile-time guarantees**, and **clean APIs**.

Designed for learning, extensibility, and real-world execution modeling.

---

## ✨ Why this framework exists

In most applications, execution logic ends up scattered:

- `try-catch` blocks everywhere
- Inconsistent error handling
- No clear contract for success vs failure
- Hard-to-test execution flows

This framework introduces a **single, explicit execution boundary** that:

- Treats execution as a **first-class concept**
- Separates **what to run** from **how it is run**
- Makes failure **explicit and typed**
- Encourages **clean, functional-style execution**

---

## 🧠 Core Design Principles

- **Functional execution model** – tasks are units of work
- **Explicit success & failure** – no hidden exceptions
- **Immutability by default** – safe data flow
- **Minimal surface area** – easy to reason about
- **Framework-friendly** – extensible, not opinionated

---

[//]: # (🏗️ Project Structure)

[//]: # (execution-api/)

[//]: # (├── Task)

[//]: # (├── ExecutionResult)

[//]: # (└── ExecutionError)

[//]: # ()
[//]: # (execution-core/)

[//]: # (├── ExecutionEngine)

[//]: # (└── Engine implementations)

[//]: # ()
[//]: # (examples/)

[//]: # (└── Usage examples)

[//]: # ()
[//]: # (doc/)

[//]: # (└── Design notes &#40;optional&#41;)
## 🎯 When to use this framework

- Modeling execution pipelines
- Learning clean API & framework design
- Avoiding exception-driven control flow
- Teaching functional-style execution in Java
- Building extensible execution engines

---

## 🚀 Quick Example (Practical Usage)

### Scenario

You are building a backend service that sends notifications.  
Some operations are **critical** (must block), others are **fire-and-forget**.

---

### ✅ Synchronous execution (critical flow)

```java
ExecutionResult<String> result =
        Execution.run(() -> {
            // business-critical operation
            return "Welcome email sent";
        })
        .sync();

if (result.isSuccess()) {
    System.out.println("Success: " + result.value());
} else {
    System.err.println("Failure: " + result.error().message());
}
```
### ⚡ Asynchronous execution (non-blocking)

```java
System.out.println("Request received");

Execution.run(() -> {
    Thread.sleep(2000); // external system call
    return "Analytics event published";
})
.async()
.onSuccess(value -> System.out.println("Async success: " + value))
.onFailure(error -> System.err.println("Async failure: " + error.message()));

System.out.println("Response returned immediately");
```

###  🧩 Why this matters in real applications

Without this framework:

```java
try {
    String result = service.call();
    log.info(result);
} catch (Exception e) {
    log.error("Failed", e);
}

```

## With this framework:

```java
Execution.run(service::call)
         .sync();


```
---
## ❌ What this framework does NOT try to be

- Not a thread pool replacement
- Not a workflow engine
- Not a scheduler
- Not opinionated about retries, timeouts, or async execution

> These concerns are intentionally left out and can be layered on top if needed.

---

## 🧠 Inspiration

This framework draws inspiration from:

- Functional programming concepts
- Result / Either types
- Clean architecture boundaries
- Java’s modern features (records, sealed types, lambdas)

---

## 📌 Final Thought

> **Execution should be explicit, predictable, and type-safe.**

This framework exists to make that the default.

---

## 📄 License

MIT License © 2026 Zaid Khan

