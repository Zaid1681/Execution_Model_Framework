# ⚙️ Execution Framework (V0)

A **simple execution framework** that runs units of work and returns
a **clear success or failure result** instead of throwing exceptions.

Built to demonstrate **clean execution boundaries** and **type-safe APIs** in Java.

---

## ✨ Features

- Functional task execution
- Explicit success and failure handling
- Type-safe execution results
- Immutable error modeling
- Lambda-friendly API
- Minimal and easy to understand

---

## 🧠 How It Works

1. You define a **Task** (a unit of work)
2. The **Execution Engine** runs the task
3. The outcome is wrapped in an **ExecutionResult**
    - Success → value
    - Failure → error

Exceptions are **caught inside the engine** and converted into data.

---

## 🤔 Why This Is Useful

Without this framework:
- Execution logic is mixed with business logic
- `try-catch` blocks are scattered everywhere
- Failure handling is inconsistent

With this framework:
- Execution is **centralized**
- Failure is **explicit**
- Code is **cleaner and easier to test**

---

## 🚀 Example Usage

### Successful execution

__var result = Execution.run(() -> {
    System.out.println("Sending Email...");
    return "Email Sent";
});

if (result.isSuccess()) {
    System.out.println("Result: " + result.value());
} else {
    System.err.println("Error: " + result.error().message());
}

Failed execution
var result = Execution.run(() -> {
    throw new RuntimeException("SMTP server not reachable");
});__


No unhandled exceptions.
The failure is returned as data.

### 🧩 Core Concepts

Task – a unit of work

ExecutionEngine – runs the task

ExecutionResult – represents success or failure

ExecutionError – immutable error information

### 🎯 When to Use

Learning execution model design

Avoiding exception-driven control flow

Writing clean, testable execution logic

Building extensible execution engines

### ❌ What This Framework Is Not

Not a thread pool

Not a scheduler

Not a workflow engine

Not opinionated about retries or async

These can be added later if needed.

### 📄 License

MIT License © 2026 Zaid Khan
