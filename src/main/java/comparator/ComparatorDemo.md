# Java Comparator Interface Guide

A comprehensive guide to understanding and using the `Comparator` interface in Java for custom sorting operations.

## 📋 Table of Contents

- [Overview](#overview)
- [What is a Comparator?](#what-is-a-comparator)
- [The compare() Method](#the-compare-method)
- [Implementation Approaches](#implementation-approaches)
- [Sorting Custom Objects](#sorting-custom-objects)
- [Advanced Java 8+ Features](#advanced-java-8-features)
- [Code Examples](#code-examples)
- [Best Practices](#best-practices)
- [Common Pitfalls](#common-pitfalls)

## 🎯 Overview

The `Comparator` interface in Java provides a way to define custom sorting logic for objects. It's essential when the natural ordering of objects isn't sufficient or when you need multiple sorting criteria.

## 🔍 What is a Comparator?

A `Comparator` is a functional interface that enables custom sorting by:
- Defining how two objects should be compared
- Allowing multiple sorting strategies for the same class
- Supporting complex sorting scenarios (multiple criteria, null handling, etc.)

```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
    // default and static methods...
}
```

## ⚖️ The compare() Method

The heart of the `Comparator` interface is the `compare(T o1, T o2)` method:

| Return Value | Meaning | Order |
|-------------|---------|-------|
| **Negative Integer** (`< 0`) | `o1` comes before `o2` | `o1 < o2` |
| **Zero** (`= 0`) | `o1` and `o2` are equal | `o1 = o2` |
| **Positive Integer** (`> 0`) | `o1` comes after `o2` | `o1 > o2` |

### Example Logic:
```java
// Ascending order: o1.value - o2.value
// Descending order: o2.value - o1.value
```

## 🛠️ Implementation Approaches

### 1. Separate Implementation Class

Create a dedicated class that implements `Comparator<T>`:

```java
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length()); // Ascending
        // return Integer.compare(o2.length(), o1.length()); // Descending
    }
}

// Usage
List<String> words = Arrays.asList("apple", "hi", "banana");
words.sort(new StringLengthComparator());
```

### 2. Lambda Expressions (Recommended)

Use lambda expressions for concise, inline comparators:

```java
// Sort integers in descending order
List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
numbers.sort((o1, o2) -> Integer.compare(o2, o1));

// Sort strings by length (ascending)
List<String> words = Arrays.asList("apple", "hi", "banana");
words.sort((a, b) -> Integer.compare(a.length(), b.length()));
```

### 3. Method References

Clean and readable approach using method references:

```java
// Natural ordering
numbers.sort(Integer::compareTo);

// Using Comparator.comparing()
words.sort(Comparator.comparing(String::length));
```

## 👨‍🎓 Sorting Custom Objects

When working with custom classes like `Student`, you must provide a `Comparator`:

```java
class Student {
    private String name;
    private double gpa;
    
    // constructors, getters, etc.
}

List<Student> students = Arrays.asList(
    new Student("Alice", 3.8),
    new Student("Bob", 3.5),
    new Student("Charlie", 3.9)
);

// Sort by GPA (descending)
students.sort((s1, s2) -> {
    if (s2.getGPA() > s1.getGPA()) return 1;
    if (s2.getGPA() < s1.getGPA()) return -1;
    return 0;
});

// Or more simply:
students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
```

## 🚀 Advanced Java 8+ Features

### Comparator.comparing()

Static method that extracts a sort key from objects:

```java
// Sort by GPA (ascending)
students.sort(Comparator.comparing(Student::getGPA));

// Sort by name (ascending)
students.sort(Comparator.comparing(Student::getName));
```

### reversed()

Reverse the order of any comparator:

```java
// Sort by GPA (descending)
students.sort(Comparator.comparing(Student::getGPA).reversed());
```

### thenComparing()

Add secondary sorting criteria:

```java
// Sort by GPA (descending), then by name (ascending) for ties
students.sort(
    Comparator.comparing(Student::getGPA).reversed()
              .thenComparing(Student::getName)
);
```

### Null Handling

Handle null values gracefully:

```java
// Nulls last
Comparator<String> nullSafeComparator = 
    Comparator.nullsLast(Comparator.naturalOrder());

// Nulls first
Comparator<String> nullFirstComparator = 
    Comparator.nullsFirst(Comparator.naturalOrder());
```

## 💻 Code Examples

### Complete Example with Multiple Approaches

```java
public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 3.8),
            new Student("Bob", 3.5),
            new Student("Charlie", 3.9),
            new Student("Diana", 3.8)
        );
        
        System.out.println("Original: " + students);
        
        // 1. Lambda expression
        students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
        System.out.println("By GPA (desc): " + students);
        
        // 2. Method reference with multiple criteria
        students.sort(
            Comparator.comparing(Student::getGPA).reversed()
                      .thenComparing(Student::getName)
        );
        System.out.println("By GPA (desc), then name (asc): " + students);
        
        // 3. Custom complex sorting
        students.sort(Comparator
            .comparing(Student::getGPA, Comparator.reverseOrder())
            .thenComparing(Student::getName, String.CASE_INSENSITIVE_ORDER)
        );
    }
}
```

### String Sorting Examples

```java
List<String> words = Arrays.asList("Abhishek", "Neha", "Ravi", "Gaurav");

// By length (ascending)
words.sort(Comparator.comparing(String::length));

// By length (descending)  
words.sort(Comparator.comparing(String::length).reversed());

// Alphabetically (case-insensitive)
words.sort(String.CASE_INSENSITIVE_ORDER);
```

## ✅ Best Practices

1. **Use `Integer.compare()`, `Double.compare()`, etc.** instead of manual subtraction to avoid overflow
   ```java
   // ✅ Good
   (a, b) -> Integer.compare(a, b)
   
   // ❌ Avoid (overflow risk)
   (a, b) -> a - b
   ```

2. **Prefer lambda expressions** over separate classes for simple comparisons

3. **Use method references** when possible for better readability
   ```java
   // ✅ Clean
   students.sort(Comparator.comparing(Student::getName));
   
   // ✅ Also good
   students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
   ```

4. **Chain comparators** for multiple sorting criteria
   ```java
   Comparator.comparing(Student::getGPA).reversed()
             .thenComparing(Student::getName)
   ```

5. **Handle null values** explicitly when needed
   ```java
   Comparator.nullsLast(Comparator.comparing(Student::getName))
   ```

## ⚠️ Common Pitfalls

1. **Integer Overflow**: Using `a - b` can cause overflow
   ```java
   // ❌ Dangerous
   (a, b) -> a - b  // Can overflow!
   
   // ✅ Safe
   (a, b) -> Integer.compare(a, b)
   ```

2. **Inconsistent Comparison**: Ensure your comparator is consistent
   ```java
   // ❌ Inconsistent (violates transitivity)
   if (condition) return 1;
   else return -1;  // No zero case!
   ```

3. **Null Pointer Exceptions**: Handle nulls properly
   ```java
   // ❌ Will throw NPE if name is null
   (s1, s2) -> s1.getName().compareTo(s2.getName())
   
   // ✅ Null-safe
   Comparator.comparing(Student::getName, Comparator.nullsLast(Comparator.naturalOrder()))
   ```

## 📚 Key Takeaways

- `Comparator` enables custom sorting logic beyond natural ordering
- The `compare()` method returns negative, zero, or positive integers
- Lambda expressions provide the most concise implementation
- Java 8+ features like `comparing()`, `reversed()`, and `thenComparing()` make complex sorting elegant
- Always consider null handling and avoid integer overflow
- Use `Collections.sort(list, comparator)` as an alternative to `list.sort(comparator)`

## 🎥 Reference

This guide is based on the comprehensive tutorial: [Java Comparator Interface Explained](https://youtu.be/XgF7XNLNf38?si=5LRQO95kvAqjk3-y)

---

**Happy Coding! 🚀**