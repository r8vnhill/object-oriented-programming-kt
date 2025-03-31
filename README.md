# Object-Oriented Programming in Kotlin

This repository contains practical examples and supporting code for learning **object-oriented programming (OOP)** using Kotlin. It is part of the course **Diseño e Implementación de Bibliotecas de Software (DIBS)** — *Design and Implementation of Software Libraries* — offered in Spanish.

> 🧑‍🏫 Although the course is taught in Spanish, all the code (including comments and documentation) is written in **English** to make it more accessible to a broader audience.

> ✅ The examples prioritize clarity, safe design, and idiomatic Kotlin practices.

## 📚 Current Lesson: Open and Closed Classes

The first module focuses on **open and closed classes**, a foundational topic for designing **safe and extensible APIs**.

In Kotlin, classes and methods are **closed by default** — they cannot be inherited or overridden unless explicitly marked with the `open` modifier. This lesson shows how this default behavior protects your code from the **fragile base class problem** and aligns with the **Open/Closed Principle**.

### 🗂️ Module structure

```
open-closed/
└── src/main/kotlin/cl/ravenhill/
    └── database/
        ├── DatabaseConnection.kt
        └── EncryptedDatabaseConnection.kt
```

### Files

- `DatabaseConnection.kt`: A base class with selective use of `open` to control inheritance.
- `EncryptedDatabaseConnection.kt`: A subclass that safely overrides a specific method.

### 🔗 Lesson Link

Read the full lesson here:  
👉 **[Open and Closed Classes for Inheritance](https://dibs.pages.dev/docs/oop/open-closed/open-closed-kt)**

## 🧠 Goals

This project is intended to help you:

- Understand OOP concepts from a Kotlin perspective.
- Write safer, more maintainable object-oriented code.
- Design library APIs that are robust and extensible.
