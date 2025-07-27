# ☕ Java Collections Framework Practice

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Collections](https://img.shields.io/badge/Collections-Framework-green?style=for-the-badge)
![Streams](https://img.shields.io/badge/Streams-API-blue?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

> 🎯 **A comprehensive repository for practicing Java Collections Framework, Maps, Streams API, and Comparators with hands-on examples and detailed documentation.**

---

## 📑 Table of Contents

- [🔍 Overview](#-overview)
- [🏗️ Project Structure](#️-project-structure)
- [📚 Topics Covered](#-topics-covered)
- [🚀 Getting Started](#-getting-started)
- [📖 Documentation](#-documentation)
- [💻 Running Examples](#-running-examples)
- [🤝 Contributing](#-contributing)
- [📝 License](#-license)

---

## 🔍 Overview

This repository serves as a **comprehensive learning resource** for Java Collections Framework and related APIs. Each topic includes:

- ✅ **Practical code examples** with detailed comments
- 📋 **Complete documentation** explaining concepts and usage
- ⚡ **Performance analysis** and time complexity discussions
- 🎯 **Best practices** and common pitfalls to avoid
- 🧪 **Hands-on exercises** to reinforce learning

---

## 🏗️ Project Structure

```
└── 📁Collections
    └── 📁src
        └── 📁main
            └── 📁java
                └── 📁comparator
                    ├── ComparatorDemo.java
                    ├── ComparatorDemo.md
                └── 📁list
                    ├── ArrayListDemo.java
                    ├── ArrayListDemo.md
                    ├── LinkedListDemo.java
                    ├── LinkedListDemo.md
                ├── collections.md
            └── 📁resources
        └── 📁test
            └── 📁java
    ├── .gitignore
    ├── Collections.iml
    ├── pom.xml
    └── Readme.md
```

---

## 📚 Topics Covered

### 🗂️ **Collections Framework**
| Topic | Status | Description |
|-------|--------|-------------|
| 📋 **ArrayList** | ✅ Complete | Dynamic arrays, performance analysis, best practices |
| 🔗 **LinkedList** | 🚧 Coming Soon | Doubly-linked lists, when to use vs ArrayList |
| 📚 **Vector** | 📅 Planned | Thread-safe lists, legacy considerations |
| 🥞 **Stack** | 📅 Planned | LIFO operations, use cases |

### 🗺️ **Maps Interface**
| Topic | Status | Description |
|-------|--------|-------------|
| 🔑 **HashMap** | 📅 Planned | Hash-based key-value storage |
| 🌳 **TreeMap** | 📅 Planned | Sorted maps, NavigableMap interface |
| 🔗 **LinkedHashMap** | 📅 Planned | Insertion-order preservation |
| ⚡ **ConcurrentHashMap** | 📅 Planned | Thread-safe maps |

### 🌊 **Streams API**
| Topic | Status | Description |
|-------|--------|-------------|
| 🔄 **Stream Operations** | 📅 Planned | Filter, map, reduce operations |
| 📊 **Collectors** | 📅 Planned | Grouping, partitioning, custom collectors |
| 🔀 **Parallel Streams** | 📅 Planned | Performance with parallel processing |

### ⚖️ **Comparators**
| Topic | Status | Description |
|-------|--------|-------------|
| 🔤 **Natural Ordering** | ✅ Complete | Comparable interface, custom sorting |
| 🎯 **Custom Comparators** | ✅ Complete | Lambda expressions, method references |
| 🔗 **Chaining Comparators** | ✅ Complete | Multiple sorting criteria |

---

## 🚀 Getting Started

### 📋 **Prerequisites**
- ☕ **Java 11+** (recommended Java 17 LTS)
- 🔨 **Maven 3.6+**
- 💻 **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

### 🛠️ **Setup**

1. **Clone the repository**
   ```bash
   git clone https://github.com/rayan25nov/Collections-Java.git
   cd Collections-Java
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run examples**
   ```bash
   # Run ArrayList demo
   mvn exec:java -Dexec.mainClass="list.ArrayListDemo"
   
   # Run Comparator demo
   mvn exec:java -Dexec.mainClass="comparator.ComparatorDemo"
   ```

---

## 📖 Documentation

Each package contains comprehensive documentation:

- 📋 **[ArrayList Guide](src/main/java/list/ArrayListDemo.md)** - Complete guide with performance analysis
- ⚖️ **[Comparator Guide](src/main/java/comparator/ComparatorDemo.md)** - Sorting strategies and implementations
- 📚 **[Collections Overview](src/main/java/collections.md)** - Framework architecture and interfaces

### 🎓 **Learning Path**

**Beginner Level:**
1. Start with [Collections Overview](src/main/java/collections.md)
2. Practice [ArrayList operations](src/main/java/list/ArrayListDemo.java)
3. Learn [basic sorting](src/main/java/comparator/ComparatorDemo.java)

**Intermediate Level:**
- Explore LinkedList vs ArrayList performance
- Master custom Comparators with lambda expressions
- Practice with HashMap implementations

**Advanced Level:**
- Concurrent collections and thread safety
- Stream API optimizations and parallel processing
- Custom collection implementations



### 🌟 **Happy Learning!** 🌟


[![GitHub stars](https://img.shields.io/github/stars/rayan25nov/Collections-Java?style=social)](https://github.com/rayan25nov/Collections-Java/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/rayan25nov/Collections-Java?style=social)](https://github.com/rayan25nov/Collections-Java/network/members)

</div>